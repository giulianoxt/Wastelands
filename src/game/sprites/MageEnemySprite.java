package game.sprites;

import game.GameMidlet;
import game.chapters.Chapter;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import properties.Constants;
import util.Util;

public class MageEnemySprite extends EnemySprite {
  public MageEnemySprite(Sprite sprite) {
    super(sprite);
  }

  public void update(long dt, TiledLayer walls) {
    GameMidlet game = GameMidlet.getInstance();
    Chapter chapter = (Chapter)game.getCurrentState();
    MainSprite main = chapter.getMainSprite();

    int old_x = getX(), old_y = getY();

    if (Util.getDistance2(this, main) <= Constants.ENEMY_ATTACK_DISTANCE2) {
      attackUpdate(dt, walls, main);
    }
    else {
      randomUpdate(dt, walls);
    }

    if (old_x != getX() || old_y != getY()) {
      frameElapsed += dt;

      if (frameElapsed >= Constants.ANIM_FRAME_DURATION) {
        frameElapsed = 0;
        nextFrame();
      }
    }
  }

  protected void attackUpdate(long dt, TiledLayer walls, Sprite main) {
    double mdx = 0, mdy = 0, md = dt * Constants.ENEMY_VELOCITY;

    int dx = main.getX() - getX(), dy = main.getY() - getY();

    if (Math.abs(dx) > Math.abs(dy)) {
      if (dx <= 0) {
        setAnimation(leftSeq);
        mdx -= md;
      } else {
        setAnimation(rightSeq);
        mdx += md;
      }
    } else {
      if (dy <= 0) {
        setAnimation(upSeq);
        mdy -= md;
      } else {
        setAnimation(downSeq);
        mdy += md;
      }
    }

    move((int)mdx, (int)mdy);

    if (collidesWith(walls, false)) {
      move(-(int)mdx, -(int)mdy);
    }
  }
}
