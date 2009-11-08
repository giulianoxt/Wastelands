package game.attacks;

import game.chapters.Chapter;

public class SingleFire extends AttackSensor {
  public boolean update(long dt, int keyState) {
    return false;
  }

  public void run(Chapter c) {
  }

  private boolean firePressed;
  private long elapsedTime;
}
