package game.sprites;

import game.GameDesign;
import game.GameMidlet;
import game.chapters.Chapter;
import game.fx.SpiderMinePower;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import properties.Constants;
import util.Util;

public class SpiderEnemySprite extends EnemySprite {
  public SpiderEnemySprite(Sprite sprite) {
    super(sprite, null, null, null, null);

    GameDesign design = GameMidlet.getDesignInstance();

    upSeq = design.RobotGrayWalkUp;
    downSeq = design.RobotGrayWalkDown;
    leftSeq = design.RobotGrayWalkLeft;
    rightSeq = design.RobotGrayWalkRight;

    current = null;
    setAnimation(downSeq);

    elapsed = 0;
  }

  public void update(long dt, TiledLayer walls) {
    int old_x = getX(), old_y = getY();

    randomUpdate(dt, walls);

    if (old_x != getX() || old_y != getY()) {
      frameElapsed += dt;

      if (frameElapsed >= Constants.ANIM_FRAME_DURATION) {
        frameElapsed = 0;
        nextFrame();
      }
    }

    elapsed += dt;

    if (elapsed >= Constants.MINER_ATTACK_DELAY) {
      elapsed = 0;

      SpiderMinePower power = new SpiderMinePower();
      Util.adjustPositionToMovement(power, this, 0);

      Chapter c = (Chapter)GameMidlet.getInstance().getCurrentState();
      c.addPower(power);
    }
  }

  private long elapsed;
}
