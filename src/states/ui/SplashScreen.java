package states.ui;

import states.base.*;
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

  public void update(long delta) { 
    timeElapsed += delta;

    if (timeElapsed >= Constants.SPLASH_DURATION ||
        getKeyStates() != 0) {
      game.gotoState(new MainMenu());
    }
  }

  public void draw(Graphics g) {
    g.drawImage(splashImage, 0, 0, Graphics.LEFT | Graphics.TOP);
  }
}
