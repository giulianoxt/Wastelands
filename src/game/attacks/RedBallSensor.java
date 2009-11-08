package game.attacks;

import game.chapters.Chapter;
import game.fx.LongRangePower;
import game.sprites.MainSprite;
import javax.microedition.lcdui.game.GameCanvas;
import properties.Constants;
import util.Util;

public class RedBallSensor extends AttackSensor {
  public RedBallSensor() {
    state = 0;
    elapsed = 0;
    a_pressed = c_pressed = false;
  }

  public boolean update(long dt, int keyState) {
    int bits = GameCanvas.GAME_A_PRESSED | GameCanvas.GAME_C_PRESSED;

    if (firePressed(keyState) ||
        gameBPressed(keyState) ||
        gameDPressed(keyState)) {
      state = 0;
      return false;
    }

    boolean a_event = false, c_event = false;

    if (gameAPressed(keyState)) {
      if (!a_pressed) {
        a_pressed = true;
        a_event = true;
      }
    } else {
      a_pressed = false;
    }

    if (gameCPressed(keyState)) {
      if (!c_pressed) {
        c_pressed = true;
        c_event = true;
      }
    } else {
      c_pressed = false;
    }

    elapsed += dt;

    switch (state) {
      // esperando A
      case 0:
        if (a_event) {
          state = 1;
          elapsed = 0;
        }
        break;

      // esperando A
      case 1:
        if (elapsed > Constants.DOUBLE_PRESS_WINDOW) {
          state = 0;
        } else if (a_event) {
          state = 2;
          elapsed = 0;
        }

        break;

      // esperando C
      case 2:
        if (elapsed > Constants.DOUBLE_PRESS_WINDOW) {
          state = 0;
        } else if (c_event) {
          state = 0;
          return true;
        }
    }

    return false;
  }

  public void run(Chapter c) {
    LongRangePower power = new LongRangePower(
      30, Util.getImage("/sprites/red_ball.png")
    );

    MainSprite main = c.getMainSprite();
    int movement = main.getMovement();

    power.setMovement(movement);
    Util.adjustPositionToMovement(power, main, movement);

    c.addPower(power);
  }

  private int state;
  private long elapsed;

  private boolean a_pressed, c_pressed;
}
