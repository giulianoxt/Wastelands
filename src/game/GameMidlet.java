package game;

import game.base.State;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import game.states.ui.SplashScreen;
import java.util.Random;

public class GameMidlet extends MIDlet implements Runnable {
  private State state;
  private boolean paused;
  private static Random random = new Random();
  private static GameMidlet midletInstance;
  private static GameDesign gameDesignInstance;

  public GameMidlet() {
    state = null;
    midletInstance = this;
    State.setGameMidlet(this);
  }

  public static GameMidlet getInstance() {
    return midletInstance;
  }

  public static GameDesign getDesignInstance() {
    if (gameDesignInstance == null)
      gameDesignInstance = new GameDesign();

    return gameDesignInstance;
  }

  public static Random getRandomInstance() {
    return random;
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

  public State getCurrentState() {
    return state;
  }

  public void run() {
    long last_time = getTime();
    long tick_time = 1000 / properties.Constants.FPS;

    while (true) {
      try {
        if (state == null)
          continue;
      
        long t1 = getTime();
        long dt = t1 - last_time;

        if (!paused)
          if (state != null) state.update(dt);

        if (state != null) state.draw();

        long t2 = getTime();
        long proc_time = t2 - t1;
        long wait_time = tick_time - proc_time;

        last_time = t2;

        if (wait_time > 0)
          Thread.sleep(wait_time);
      }
      catch (IllegalArgumentException e) {
        e.printStackTrace();
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private long getTime() {
    return System.currentTimeMillis();
  }
}
