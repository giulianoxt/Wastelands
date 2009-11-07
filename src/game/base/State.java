package game.base;

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

  public void init() { }
  public void dispose() { }
  public void update(long dt) { }
  public void draw(Graphics g) { }

  public static void setGameMidlet(GameMidlet midlet) {
    game = midlet;
  }

  protected static GameMidlet game;
}
