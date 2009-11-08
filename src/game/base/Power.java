package game.base;

import game.GameMidlet;
import game.chapters.Chapter;
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

  public void remove() {
    getCurrentChapter().removePower(this);
  }

  public abstract void update(long dt, int keyState);
  public abstract void collidedWith(Sprite p);
  public abstract boolean collidedWithWall();

  protected int damage;

  public static Chapter getCurrentChapter() {
    return (Chapter)GameMidlet.getInstance().getCurrentState();
  }
}
