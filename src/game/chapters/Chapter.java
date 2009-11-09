package game.chapters;

import game.GameDesign;
import game.GameMidlet;
import game.attacks.AttackSensor;
import game.base.Power;
import util.Point;
import game.base.State;
import game.dialogs.DialogSensor;
import game.sprites.EnemySprite;
import game.sprites.MageEnemySprite;
import game.sprites.MainSprite;
import game.sprites.SpiderEnemySprite;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import properties.Constants;
import util.Util;

public abstract class Chapter extends State {
  public Chapter(String id, String name) {
    chapterId = id;
    chapterName = name;

    hpSprite = new Sprite(Util.getImage("/sprites/bolt.png"));
    manaSprite = new Sprite(Util.getImage("/sprites/mana.png"));

    powers = new Vector(5);
    dialogSensors = new Vector(5);
    enemies = new Vector(10);

    interfaceImg = Util.getImage("/sprites/interface.png");
  }

  public String getId() {
    return chapterId;
  }

  public String getName() {
    return chapterName;
  }

  public Point getEndPoint() {
    return endPoint;
  }

  public MainSprite getMainSprite() {
    return mainSprite;
  }

  public void setEndPoint(Point endPoint) {
    this.endPoint = endPoint;
  }

  public Point getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(Point startPoint) {
    this.startPoint = startPoint;
  }

  public TiledLayer getWallLayer() {
    return wallLayer;
  }

  public LayerManager getLayerManager() {
    return layerManager;
  }

  public Vector getPowers() {
    return powers;
  }

  public void setWallLayer(TiledLayer wallLayer) {
    this.wallLayer = wallLayer;
  }

  public void setMainChar(Sprite main) {
    mainChar = main;
  }

  public void addDialogSensor(DialogSensor sensor) {
    dialogSensors.addElement(sensor);
  }

  protected void setupChapter() {
    setupMainSprite();
    setupEnemies();
    setupSensors();
    setupLayerManager();
  }
  
  protected void setupMainSprite() {
    mainSprite = new MainSprite(mainChar);
    mainSprite.setHP(Constants.INITIAL_HP);
    mainSprite.setMana(Constants.INITIAL_MANA);
  }

  protected void setupEnemies() {
    Hashtable props = Util.readPropertyFile(chapterId);

    setStartPoint(Util.readTuple((String)props.get("start_pos")));
    setEndPoint(Util.readTuple((String)props.get("end_pos")));

    props.remove("start_pos");
    props.remove("end_pos");

    EnemySprite enemy = null;
    GameDesign design = GameMidlet.getDesignInstance();

    for (Enumeration e = props.keys(); e.hasMoreElements(); ) {
      String key = (String)e.nextElement();
      Point pos = Util.readTuple((String)props.get(key));

      if (!key.startsWith("#"))
        continue;

      key = key.substring(1);

      try {
        if (key.startsWith("GuardPunk")) {
          enemy = new SpiderEnemySprite(design.getRobotGray());
          enemy.setHP(100);
        } else if (key.startsWith("GuardYellow")) {
          enemy = new MageEnemySprite(design.getRobotLight());
          enemy.setHP(50);
        } else {
          continue;
        }

        enemy.setPosition(fromLayerToScene(pos));
      } catch (IOException exp) {
        continue;
      }

      enemies.addElement(enemy);
    }
  }

  protected void addEnemy(EnemySprite enemy) {
    enemies.addElement(enemy);
  }

  protected void setupSensors() {
    attackSensors = AttackSensor.getAttackSensors();
  }

  protected void setupLayerManager() {
    layerManager = new LayerManager();
    layerManager.setViewWindow(
      0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT
    );

    layerManager.append(hpSprite);
    layerManager.append(manaSprite);
    layerManager.append(mainSprite);
    mainSprite.setPosition(fromLayerToScene(getStartPoint()));

    for (int i = 0; i < enemies.size(); ++i) {
      layerManager.append((Sprite)enemies.elementAt(i));
    }

    layerManager.append(wallLayer);
  }

  public void addPower(Power p) {
    powers.addElement(p);
    int pos = Math.max(0, layerManager.getSize() - 2);
    layerManager.insert(p, pos);
  }

  public void removePower(Power p) {
    powers.removeElement(p);
    layerManager.remove(p);
  }

  protected void updateMainSprite(long dt, int keyState) {
    Point old_pos = new Point(mainSprite.getX(), mainSprite.getY());

    mainSprite.update(dt, keyState);

    if (mainSprite.collidesWith(wallLayer, false)) {
      mainSprite.setPosition(old_pos);
    }
  }

  protected void updateEnemies(long dt) {
    for (Enumeration e = enemies.elements(); e.hasMoreElements();) {
      EnemySprite enemy = (EnemySprite)e.nextElement();
      enemy.update(dt, wallLayer);
    }
  }

  protected void updatePowers(long dt, int keyState) {
    Vector to_remove = new Vector();

    for (Enumeration e = powers.elements(); e.hasMoreElements();) {
      Power p = (Power)e.nextElement();
      p.update(dt, keyState);

      if (p.collidesWith(wallLayer, true) && p.collidedWithWall())
        to_remove.addElement(p);

      for (Enumeration e2 = enemies.elements(); e2.hasMoreElements();) {
        EnemySprite enemy = (EnemySprite)e2.nextElement();

        if (p.collidesWith(enemy, true)) {
          p.collidedWith(enemy);

          if (enemy.getHP() == 0)
            to_remove.addElement(enemy);
        }
      }

      if (p.collidesWith(mainSprite, true)) {
        p.collidedWith(mainSprite);
      }
    }

    for (Enumeration e = to_remove.elements(); e.hasMoreElements();) {
      Sprite s = (Sprite)e.nextElement();
      powers.removeElement(s);
      enemies.removeElement(s);
      layerManager.remove(s);
    }
  }

  protected void updateAttackSensors(long dt, int keyState) {
    for (int i = 0; i < attackSensors.length; ++i) {
      AttackSensor sensor = attackSensors[i];

      if (sensor.update(dt, keyState)) {
        sensor.run(this);
      }
    }
  }

  protected void updateDialogSensors(long dt, int keyState) {
    for (int i = 0; i < dialogSensors.size(); ++i) {
      DialogSensor sensor = (DialogSensor)dialogSensors.elementAt(i);
      sensor.update(dt, keyState);
    }
  }

  protected void updateViewWindow() {
    int view_w = Constants.SCREEN_WIDTH;
    int view_h = Constants.SCREEN_HEIGHT;
    int view_w2 = view_w / 2, view_h2 = view_h / 2;

    int main_x = mainSprite.getX(), main_y = mainSprite.getY();
    int scene_w = wallLayer.getWidth(), scene_h = wallLayer.getHeight();

    int min_x = main_x - view_w2, max_x = main_x + view_w2;
    int min_y = main_y - view_h2, max_y = main_y + view_h2;

    int viewc_x, viewc_y;

    if (min_x < 0) {
      viewc_x = view_w2;
    } else if (max_x > scene_w) {
      viewc_x = scene_w - view_w2;
    } else {
      viewc_x = main_x;
    }

    if (min_y < 0) {
      viewc_y = view_h2;
    } else if (max_y > scene_h) {
      viewc_y = scene_h - view_h2;
    } else {
      viewc_y = main_y;
    }

    int viewc_tx = viewc_x - view_w2;
    int viewc_ty = viewc_y - view_h2;

    layerManager.setViewWindow(viewc_tx, viewc_ty, view_w, view_h);

    hpSprite.setPosition(
      viewc_tx + Constants.HP_X,
      viewc_ty + Constants.HP_Y
    );

    manaSprite.setPosition(
      viewc_tx + Constants.MANA_X,
      viewc_ty + Constants.MANA_Y
    );
  }

  protected Point fromLayerToScene(Point p) {
    return new Point(
      p.getX() * wallLayer.getCellWidth(),
      p.getY() * wallLayer.getCellHeight()
    );
  }

  public void draw(Graphics g) {
    g.setColor(0, 0, 0);
    g.fillRect(0, 0, wallLayer.getWidth(), wallLayer.getHeight());
    layerManager.paint(g, 0, 0);

    g.setColor(255, 255, 255);

    g.drawString(
      "" + mainSprite.getHP(),
      Constants.HP_X + hpSprite.getWidth() + 3,
      Constants.HP_Y + hpSprite.getHeight() / 2 - 8,
      Graphics.TOP | Graphics.LEFT
    );

    g.drawString(
      "" + mainSprite.getMana(),
      manaSprite.getWidth(),
      Constants.MANA_Y + manaSprite.getHeight() / 2 - 8,
      Graphics.TOP | Graphics.LEFT
    );

    g.drawImage(
      interfaceImg, 0, 0, Graphics.TOP | Graphics.LEFT
    );
  }

  protected String chapterId, chapterName;
  
  protected Point startPoint, endPoint;
  protected TiledLayer wallLayer;

  protected MainSprite mainSprite;
  protected Vector powers, enemies;
  protected LayerManager layerManager;

  protected Vector dialogSensors;
  protected AttackSensor[] attackSensors;

  protected Sprite mainChar;
  protected Sprite hpSprite, manaSprite;

  protected Image interfaceImg;
}
