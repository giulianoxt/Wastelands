package game.chapters;

import game.GameDesign;
import game.GameMidlet;
import javax.microedition.lcdui.game.*;

public class RobotFacilityAChapter extends Chapter {
  public RobotFacilityAChapter() {
    super("robot_facility_a", "Robot Facility A");

    Sprite mainChar = null;
    TiledLayer walls = null;

    try {
      GameDesign design = GameMidlet.getDesignInstance();
      mainChar = design.getMainSprite();
      walls = design.getRobotFacilityA();
    } catch (Exception e) {
      e.printStackTrace();
    }

    setWallLayer(walls);
    setMainChar(mainChar);
    setupChapter();
  }

  public void update(long dt) {
    int keyState = getKeyStates();

    updateMainSprite(dt, keyState);
    updateEnemies(dt, keyState);
    updateViewWindow();
  }
}
