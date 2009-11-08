package game.attacks;

import game.chapters.Chapter;
import game.fx.LongRangePower;
import game.sprites.MainSprite;
import properties.Constants;
import util.Util;

public class BlueBallSensor extends AttackSensor {
  public BlueBallSensor() {
    state = 0;
    elapsed = 0;
    b_pressed = a_pressed = false;
  }

  public boolean update(long dt, int keyState) {
    if (firePressed(keyState) ||
        gameCPressed(keyState) ||
        gameDPressed(keyState)) {
      state = 0;
      return false;
    }

    boolean b_event = false, a_event = false;

    if (gameBPressed(keyState)) {
      if (!b_pressed) {
        b_pressed = true;
        b_event = true;
      }
    } else {
      b_pressed = false;
    }

    if (gameAPressed(keyState)) {
      if (!a_pressed) {
        a_pressed = true;
        a_event = true;
      }
    } else {
      a_pressed = false;
    }

    elapsed += dt;

    switch (state) {
      // esperando B
      case 0:
        if (b_event) {
          state = 1;
          elapsed = 0;
        }
        break;

      // esperando B
      case 1:
        if (elapsed > Constants.DOUBLE_PRESS_WINDOW) {
          state = 0;
        } else if (b_event) {
          state = 2;
          elapsed = 0;
        }

        break;

      // esperando A
      case 2:
        if (elapsed > Constants.DOUBLE_PRESS_WINDOW) {
          state = 0;
        } else if (a_event) {
          state = 0;
          return true;
        }
    }

    return false;
  }

  public void run(Chapter c) {
    LongRangePower power = new LongRangePower(
      30, Util.getImage("/sprites/blue_ball.png")
    );

    MainSprite main = c.getMainSprite();
    int movement = main.getMovement();

    power.setMovement(movement);
    Util.adjustPositionToMovement(power, main, movement);

    c.addPower(power);
  }

  private int state;
  private long elapsed;

  private boolean b_pressed, a_pressed;
}
