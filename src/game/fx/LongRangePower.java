package game.fx;

import util.Util;
import game.base.Power;
import properties.Constants;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class LongRangePower extends Power {
  public LongRangePower(int damage, Image image) {
    super(damage, image);
    setRefPixelPosition(image.getWidth()/2, image.getHeight()/2);
  }

  public void setMovement(int movement) {
    switch (movement) {
      case 0:
        mov_y = -1;
        setTransform(TRANS_ROT270);
        break;
      case 1:
        mov_y = 1;
        setTransform(TRANS_ROT90);
        break;
      case 2:
        mov_x = -1;
        setTransform(TRANS_MIRROR);
        break;
      case 3:
        mov_x = 1; break;
    }
  }

  public void update(long dt, int keyState) {
    int d = (int)(dt * Constants.POWER_VELOCITY);
    move(d * mov_x, d * mov_y);
  }

  public void collidedWith(Sprite s) {
    if (Util.hitEnemy(damage, s))
      remove();
  }

  public boolean collidedWithWall() {
    return true;
  }

  private int mov_x, mov_y;
}
