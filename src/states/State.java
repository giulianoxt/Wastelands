package states;

import game.GameMidlet;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public abstract class State extends GameCanvas {
  public State() {
    super(false);
    setFullScreenMode(true);
  }

  public void draw() {
    draw(getGraphics());
    flushGraphics();
  }

  public abstract void init();
  public abstract void dispose();
  public abstract void update(long dt);
  public abstract void draw(Graphics g);

  public static void setGameMidlet(GameMidlet midlet) {
    game = midlet;
  }

  protected static GameMidlet game;
}
