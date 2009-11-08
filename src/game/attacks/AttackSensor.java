package game.attacks;

import game.chapters.Chapter;
import javax.microedition.lcdui.game.GameCanvas;

public abstract class AttackSensor {
  private static AttackSensor[] sensors = {
    new LightSaber()
  };

  public static AttackSensor[] getAttackSensors() {
    return sensors;
  }

  public abstract boolean update(long dt, int keyState);
  public abstract void run(Chapter c);

  public static boolean firePressed(int keyState) {
    return keyPressed(keyState, GameCanvas.FIRE_PRESSED);
  }

  public static boolean leftPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.LEFT_PRESSED);
  }

  public static boolean rightPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.RIGHT_PRESSED);
  }

  public static boolean upPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.UP_PRESSED);
  }

  public static boolean downPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.DOWN_PRESSED);
  }

  public static boolean gameAPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.GAME_A_PRESSED);
  }

  public static boolean gameBPressed(int keyState) {
    return keyPressed(keyState, GameCanvas.GAME_B_PRESSED);
  }

  public static boolean keyPressed(int keyState, int keyBit) {
    return (keyState & keyBit) != 0;
  }
}
