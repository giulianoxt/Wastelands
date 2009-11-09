package game.sprites;

import util.Point;
import game.GameDesign;
import game.GameMidlet;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import properties.Constants;

public class EnemySprite extends Sprite {
  public EnemySprite(Sprite sprite,
          int[] up, int[] down, int[] left, int[] right) {
    super(sprite);
    setRefPixelPosition(0, 0);

    upSeq = up;
    downSeq = down;
    leftSeq = left;
    rightSeq = right;

    current = null;
    setAnimation(downSeq);
  }

  public void setPosition(Point p) {
    setPosition(p.getX(), p.getY());
  }

  protected void setAnimation(int[] seq) {
    if (seq != current)
      frameElapsed = 0;

    current = seq;
    setFrameSequence(seq);
  }

  public int getHP() {
    return hp;
  }

  public void setHP(int _hp) {
    hp = _hp;
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
  }

  protected void randomUpdate(long dt, TiledLayer walls) {
    double dx = 0, dy = 0, d = dt * Constants.ENEMY_VELOCITY;

    if (current == leftSeq) {
      dx -= d;
    } else if (current == rightSeq) {
      dx += d;
    } else if (current == upSeq) {
      dy -= d;
    } else if (current == downSeq) {
      dy += d;
    }

    move((int)dx, (int)dy);

    if (collidesWith(walls, false)) {
      move(-(int)dx, -(int)dy);

      int r = GameMidlet.getRandomInstance().nextInt(4);

      if (r == 0)
        setAnimation(upSeq);
      else if (r == 1)
        setAnimation(downSeq);
      else if (r == 2)
        setAnimation(leftSeq);
      else
        setAnimation(rightSeq);
    }
  }

  protected int hp;
  protected int[] current;
  protected long frameElapsed;
  protected int[] upSeq, downSeq, leftSeq, rightSeq;
}
