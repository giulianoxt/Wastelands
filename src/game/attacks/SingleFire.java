package game.attacks;

import util.Util;
import game.chapters.Chapter;
import game.fx.LongRangePower;
import game.sprites.MainSprite;

public class SingleFire extends AttackSensor {
  public boolean update(long dt, int keyState) {
    if (firePressed(keyState)) {
      pressed = true;
    } else if (pressed) {
      pressed = false;
      return true;
    }

    return false;
  }

  public void run(Chapter c) {
    LongRangePower power = new LongRangePower(
      30, Util.getImage("/sprites/white_ball.png")
    );

    MainSprite main = c.getMainSprite();

    power.setPosition(
      main.getX() + main.getWidth() / 2 + 2,
      main.getY() + main.getHeight() / 2
    );

    power.setMovement(main.getMovement());

    c.addPower(power);
  }

  private boolean pressed;
}
