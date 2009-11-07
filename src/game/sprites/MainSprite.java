package game.sprites;

import game.GameDesign;
import game.GameMidlet;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;
import properties.Constants;
import util.Point;

public class MainSprite extends Sprite {
  public MainSprite(Sprite original) {
    super(original);
    setRefPixelPosition(0, 0);

    GameDesign design = GameMidlet.getDesignInstance();
    upSeq = design.MainWalkUp;
    downSeq = design.MainWalkDown;
    leftSeq = design.MainWalkLeft;
    rightSeq = design.MainWalkRight;

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

  public int getMana() {
    return mana;
  }

  public void setMana(int _mana) {
    mana = _mana;
  }

  public void update(long dt, int keyState) {
    double dx = 0, dy = 0, d = dt * Constants.MAIN_VELOCITY;

    if ((keyState & GameCanvas.LEFT_PRESSED) != 0) {
      dx -= d;
      setAnimation(leftSeq);
    }
    if ((keyState & GameCanvas.RIGHT_PRESSED) != 0) {
      dx += d;
      setAnimation(rightSeq);
    }
    if ((keyState & GameCanvas.UP_PRESSED) != 0) {
      dy -= d;
      setAnimation(upSeq);
    }
    if ((keyState & GameCanvas.DOWN_PRESSED) != 0) {
      dy += d;
      setAnimation(downSeq);
    }

    if (dx != 0 || dy != 0) {
      frameElapsed += dt;

      if (frameElapsed >= Constants.ANIM_FRAME_DURATION) {
        frameElapsed = 0;
        nextFrame();
      }
    }

    move((int)dx, (int)dy);
  }


  private int hp, mana;

  private int[] current;
  private long frameElapsed;
  private int[] upSeq, downSeq, leftSeq, rightSeq;
}
