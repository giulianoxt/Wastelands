package game.fx;

import util.Util;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class EnemyLongRangePower extends LongRangePower {
  public EnemyLongRangePower(int damage, Image image) {
    super(damage, image);
  }

  public void collidedWith(Sprite s) {
    Util.hitMainSprite(damage, s);
    remove();
  }
}
