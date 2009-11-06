package game;

import states.base.State;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import states.ui.SplashScreen;

public class GameMidlet extends MIDlet implements Runnable {
  private State state;
  private boolean paused;
  private static GameMidlet instance;

  public GameMidlet() {
    state = null;
    instance = this;
    State.setGameMidlet(this);
  }

  public static GameMidlet getInstance() {
    return instance;
  }

  public void startApp() {
    paused = false;

    gotoState(new SplashScreen("/splash_wastelands.png"));

    new Thread(this).start();
  }

  public void pauseApp() {
    paused = true;
  }

  public void quit() {
    destroyApp(false);
    notifyDestroyed();
  }

  public void destroyApp(boolean unconditional) {
  }

  public void gotoState(State newState) {
    if (state != null)
      state.dispose();

    state = newState;
    state.init();
    
    Display.getDisplay(this).setCurrent(state);
  }

  public void gotoDisplayable(Displayable display) {
    state = null;
    Display.getDisplay(this).setCurrent(display);
  }

  public void run() {
    long last_time = getTime();
    long tick_time = 1000 / properties.Constants.FPS;

    while (true) {
      if (state == null)
        continue;
      
      long t1 = getTime();
      long dt = t1 - last_time;

      if (!paused)
        state.update(dt);

      state.draw();

      long t2 = getTime();
      long proc_time = t2 - t1;
      long wait_time = tick_time - proc_time;

      last_time = t2;

      try {
        Thread.sleep(wait_time);
      } catch (InterruptedException e) {
      }
    }
  }

  private long getTime() {
    return System.currentTimeMillis();
  }
}
