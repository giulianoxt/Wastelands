package game.sprites;

import util.Point;
import game.GameDesign;
import game.GameMidlet;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import properties.Constants;

public class EnemySprite extends Sprite {
  public EnemySprite(Sprite sprite) {
    super(sprite);
    setRefPixelPosition(0, 0);

    GameDesign design = GameMidlet.getDesignInstance();

    upSeq = design.GuardGreenWalkUp;
    downSeq = design.GuardGreenWalkDown;
    leftSeq = design.GuardGreenWalkLeft;
    rightSeq = design.GuardGreenWalkRight;

    current = null;
    setAnimation(downSeq);
  }

  public void setPosition(Point p) {
    setPosition(p.getX(), p.getY());
  }

  private void setAnimation(int[] seq) {
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
      dx = dy = 0;

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

    if (dx != 0 || dy != 0) {
      frameElapsed += dt;

      if (frameElapsed >= Constants.ANIM_FRAME_DURATION) {
        frameElapsed = 0;
        nextFrame();
      }
    }
  }

  private int hp;
  private int[] current;
  private long frameElapsed;
  private int[] upSeq, downSeq, leftSeq, rightSeq;
}
