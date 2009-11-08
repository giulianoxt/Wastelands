package game.fx;

import game.sprites.MainSprite;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class EnemyLongRangePower extends LongRangePower {
  public EnemyLongRangePower(int damage, Image image) {
    super(damage, image);
  }

  public void collidedWith(Sprite p) {
    if (p instanceof MainSprite) {
      MainSprite main = (MainSprite)p;
      main.setHP(Math.max(main.getHP() - getDamage(), 0));
    }
    remove();
  }
}
