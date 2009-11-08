package game.attacks;

import util.Util;
import game.chapters.Chapter;
import game.fx.LightSaberPower;
import game.fx.LongRangePower;
import game.sprites.MainSprite;
import javax.microedition.lcdui.game.GameCanvas;

public class LightSaber extends AttackSensor {
  public LightSaber() {
    pressed = false;
  }

  public boolean update(long dt, int keyState) {
    if (firePressed(keyState)) {
      if (!pressed)
        return pressed = true;
    } else {
      pressed = false;
    }

    return false;
  }

  public void run(Chapter c) {
    LightSaberPower power = new LightSaberPower();
    power.update(0, GameCanvas.FIRE_PRESSED);
    c.addPower(power);

    /*
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
    */
  }

  private boolean pressed;
}
