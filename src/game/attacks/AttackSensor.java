package game.attacks;

import game.chapters.Chapter;
import javax.microedition.lcdui.game.GameCanvas;

public abstract class AttackSensor {
  private static AttackSensor[] sensors = null;

  public static AttackSensor[] getAttackSensors() {
    if (sensors == null) {
      AttackSensor[] v = { new SingleFire() };
      sensors = v;
    }

    return sensors;
  }

  public abstract boolean update(long dt, int keyState);
  public abstract void run(Chapter c);

  protected boolean firePressed(int keyState) {
    return keyPressed(keyState, GameCanvas.FIRE_PRESSED);
  }

  protected boolean leftPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.LEFT_PRESSED);
  }

  protected boolean rightPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.RIGHT_PRESSED);
  }

  protected boolean upPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.UP_PRESSED);
  }

  protected boolean downPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.DOWN_PRESSED);
  }

  protected boolean gameAPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.GAME_A_PRESSED);
  }

  protected boolean gameBPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.GAME_B_PRESSED);
  }

  private boolean keyPressed(int keyState, int keyBit) {
    return (keyState & keyBit) != 0;
  }
}
