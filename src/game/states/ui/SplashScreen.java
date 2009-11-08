package game.states.ui;

import game.base.*;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import properties.Constants;
import util.Util;

public class SplashScreen extends State {
  protected Image splashImage;
  private long timeElapsed;

  public SplashScreen(String filepath) {
    splashImage = Util.getImage(filepath);
  }

  public void init() {
    timeElapsed = 0;
  }

  public void update(long dt) {
    timeElapsed += dt;

    if (timeElapsed >= Constants.SPLASH_DURATION ||
        getKeyStates() != 0) {
      game.gotoState(MainMenu.getInstance());
    }
  }

  public void draw(Graphics g) {
    g.drawImage(splashImage, 0, 0, Graphics.LEFT | Graphics.TOP);
  }
}
