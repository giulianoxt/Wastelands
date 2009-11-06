package game;

import states.State;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import states.SplashScreen;

public class GameMidlet extends MIDlet implements Runnable {
  private State state;
  private boolean paused;

  public GameMidlet() {
    state = null;
    State.setGameMidlet(this);
  }

  public void startApp() {
    paused = false;

    changeState(new SplashScreen("/splash_wastelands.png"));

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

  public void changeState(State newState) {
    if (state != null)
      state.dispose();

    state = newState;
    state.init();
    
    Display.getDisplay(this).setCurrent(state);
  }

  public void run() {
    long last_time = getTime();
    long tick_time = 1000 / properties.DisplayProperties.FPS;

    while (true) {
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
