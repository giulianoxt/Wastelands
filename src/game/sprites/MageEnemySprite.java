package game.sprites;

import game.GameMidlet;
import game.chapters.Chapter;
import game.fx.EnemyLongRangePower;
import game.fx.LongRangePower;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import properties.Constants;
import util.Util;

public class MageEnemySprite extends EnemySprite {
  public MageEnemySprite(Sprite sprite) {
    super(sprite);
    elapsed = 0;
  }

  public void update(long dt, TiledLayer walls) {
    GameMidlet game = GameMidlet.getInstance();
    Chapter chapter = (Chapter)game.getCurrentState();
    MainSprite main = chapter.getMainSprite();

    int old_x = getX(), old_y = getY();
    int dist2 = Util.getDistance2(this, main);

    if (dist2 <= Constants.MAGE_ATTACK_DISTANCE2) {
      attackUpdate(dt, walls, main);
    } else if (dist2 <= Constants.ENEMY_PURSUIT_DISTANCE2) {
      elapsed = 0;
      pursuitUpdate(dt, walls, main);
    }
    else {
      elapsed = 0;
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
    int movement;
    int dx = main.getX() - getX(), dy = main.getY() - getY();

    if (Math.abs(dx) > Math.abs(dy)) {
      if (dx <= 0) {
        movement = 2;
        setAnimation(leftSeq);
      }
      else {
        movement = 3;
        setAnimation(rightSeq);
      }
    }
    else {
      if (dy <= 0) {
        movement = 0;
        setAnimation(upSeq);
      }
      else {
        movement = 1;
        setAnimation(downSeq);
      }
    }

    elapsed += dt;

    if (elapsed < Constants.MAGE_ATTACK_DELAY)
      return;
    
    elapsed = 0;

    EnemyLongRangePower power = new EnemyLongRangePower(
      10, Util.getImage("/sprites/white_ball.png")
    );

    power.setMovement(movement);
    Util.adjustPositionToMovement(power, this, movement);

    Chapter c = (Chapter)GameMidlet.getInstance().getCurrentState();
    c.addPower(power);
  }

  protected void pursuitUpdate(long dt, TiledLayer walls, Sprite main) {
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

  private long elapsed;
}
