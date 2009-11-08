package game.chapters;

import game.GameDesign;
import game.GameMidlet;
import java.io.IOException;

public class RobotFacilityAChapter extends Chapter {
  public RobotFacilityAChapter() {
    super("robot_facility_a", "Robot Facility A");

    GameDesign design = GameMidlet.getDesignInstance();

    try {
      setMainChar(design.getMainSprite());
      setWallLayer(design.getRobotFacilityA());
    } catch (IOException e) {
      e.printStackTrace();
    }

    setupChapter();
  }

  public void update(long dt) {
    int keyState = getKeyStates();

    updateMainSprite(dt, keyState);
    updateEnemies(dt);
    updateSensors(dt, keyState);
    updateViewWindow();
  }
}
