package game.attacks;

import game.chapters.Chapter;
import javax.microedition.lcdui.game.GameCanvas;

public abstract class AttackSensor {
  private static AttackSensor[] sensors = {
    new RedBallSensor(),
    new BlueBallSensor(),
    new LightSaberSensor()
  };

  public static AttackSensor[] getAttackSensors() {
    return sensors;
  }

  public abstract boolean update(long dt, int keyState);
  public abstract void run(Chapter c);

  public static boolean firePressed(int keyState) {
    return pressed(keyState, GameCanvas.FIRE_PRESSED);
  }

  public static boolean leftPressed(int keyState) {
    return pressed(keyState, GameCanvas.LEFT_PRESSED);
  }

  public static boolean rightPressed(int keyState) {
    return pressed(keyState, GameCanvas.RIGHT_PRESSED);
  }

  public static boolean upPressed(int keyState) {
    return pressed(keyState, GameCanvas.UP_PRESSED);
  }

  public static boolean downPressed(int keyState) {
    return pressed(keyState, GameCanvas.DOWN_PRESSED);
  }

  public static boolean gameAPressed(int keyState) {
    return pressed(keyState, GameCanvas.GAME_A_PRESSED);
  }

  public static boolean gameBPressed(int keyState) {
    return pressed(keyState, GameCanvas.GAME_B_PRESSED);
  }

  public static boolean gameCPressed(int keyState) {
    return pressed(keyState, GameCanvas.GAME_C_PRESSED);
  }

  public static boolean gameDPressed(int keyState) {
    return pressed(keyState, GameCanvas.GAME_D_PRESSED);
  }

  private static boolean pressed(int keyState, int keyBit) {
    return (keyState & keyBit) != 0;
  }
}
