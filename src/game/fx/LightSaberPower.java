package game.fx;

import game.attacks.AttackSensor;
import game.base.Power;
import game.chapters.Chapter;
import game.sprites.MainSprite;
import javax.microedition.lcdui.game.Sprite;
import util.Util;

public class LightSaberPower extends Power {
  public LightSaberPower() {
    super(10, Util.getImage("/sprites/red_lightsaber.png"));
    setRefPixelPosition(getWidth() / 2, getHeight() / 2);
  }

  public void setMovement(int movement) {
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
    if (!AttackSensor.firePressed(keyState)) {
      Chapter chapter = getCurrentChapter();
      chapter.getLayerManager().remove(this);
      chapter.getPowers().removeElement(this);
    } else {
      MainSprite main = getCurrentChapter().getMainSprite();
      int movement = main.getMovement();

      setMovement(movement);
      int dx = 0, dy = 0;

      switch (movement) {
        case 0:
          dx = main.getWidth() - getWidth() / 2 - 4;
          dy = -(getHeight() - main.getHeight() / 2) + 6;
          break;
        case 1:
          dx = 2;
          dy = main.getHeight() / 2;
          break;
        case 2:
          dx = -(getWidth() - 10) + 4;
          dy = main.getHeight() / 2;
          break;
        case 3:
          dx = main.getWidth() / 2 + 2;
          dy = main.getHeight() / 2;
          break;
      }

      setPosition(main.getX() + dx, main.getY() + dy);
    }
  }

  public void collidedWith(Sprite p) {
    // tirar dano
  }

  public boolean collidedWithWall() {
    return false;
  }
}
