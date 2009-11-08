package game.base;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public abstract class Power extends Sprite {
  public Power(int d, Image image) {
    super(image);
    damage = d;
  }

  public int getDamage() {
    return damage;
  }

  public abstract void update(long dt);
  public abstract void collidedWith(Sprite p);

  protected int damage;
}
