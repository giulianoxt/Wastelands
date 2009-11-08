package game.fx;

import util.Util;
import game.base.Power;
import game.chapters.Chapter;
import game.sprites.EnemySprite;
import game.sprites.MainSprite;
import game.attacks.AttackSensor;
import javax.microedition.lcdui.game.Sprite;

public class LightSaberPower extends Power {
  public LightSaberPower() {
    super(10, Util.getImage("/sprites/red_lightsaber.png"));
    setRefPixelPosition(getWidth() / 2, getHeight() / 2);
  }

  public void setMovement(int movement) {
    setTransform(TRANS_NONE);
    
    switch (movement) {
      case 0:
        setTransform(TRANS_ROT270);
        break;
      case 1:
        setTransform(TRANS_ROT90);
        break;
      case 2:
        setTransform(TRANS_MIRROR);
        break;
      case 3:
        break;
    }
  }

  public void update(long dt, int keyState) {
    if (AttackSensor.firePressed(keyState)) {
      MainSprite main = getCurrentChapter().getMainSprite();
      int movement = main.getMovement();

      setMovement(movement);
      Util.adjustPositionToMovement(this, main, movement);
    } else {
      Chapter chapter = getCurrentChapter();
      chapter.getLayerManager().remove(this);
      chapter.getPowers().removeElement(this);
    }
  }

  public void collidedWith(Sprite p) {
    EnemySprite enemy = (EnemySprite)p;
    enemy.setHP(Math.max(enemy.getHP() - getDamage(), 0));
    remove();
  }

  public boolean collidedWithWall() {
    return false;
  }
}
