package game.attacks;

import game.chapters.Chapter;
import game.fx.LightSaberPower;
import javax.microedition.lcdui.game.GameCanvas;

public class LightSaberSensor extends AttackSensor {
  public LightSaberSensor() {
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
  }

  private boolean pressed;
}
