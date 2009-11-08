package game.fx;

import util.Util;
import game.GameMidlet;
import game.base.Power;
import properties.Constants;
import java.io.IOException;
import javax.microedition.lcdui.game.Sprite;

public class SpiderMinePower extends Power {
  public SpiderMinePower() {
    super(30, getSpiderSprite());

    frame_elapsed = 0;
    deploy_elapsed = 0;
  }

  private static Sprite getSpiderSprite() {
    try {
      return GameMidlet.getDesignInstance().getSpiderMine();
    } catch (IOException e) {
      return null;
    }
  }

  public void update(long dt, int keyState) {
    frame_elapsed += dt;
    deploy_elapsed += dt;

    if (frame_elapsed >= Constants.ANIM_FRAME_DURATION) {
      frame_elapsed = 0;
      nextFrame();
    }

    if (deploy_elapsed >= Constants.MINE_POWER_DURATION) {
      remove();
    }
  }

  public void collidedWith(Sprite p) {
    if (Util.hitMainSprite(damage, p)) {
      remove();
    }
  }

  public boolean collidedWithWall() {
    return true;
  }

  private long frame_elapsed;
  private long deploy_elapsed;
}
