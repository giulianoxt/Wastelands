package game.chapters;

import game.GameDesign;
import game.GameMidlet;
import game.dialogs.EndLevelSensor;
import game.dialogs.InitialDialog;
import java.io.IOException;

public class RobotFacility1 extends Chapter {
  public RobotFacility1() {
    super("robot_facility_1", "Robot Facility 1");

    GameDesign design = GameMidlet.getDesignInstance();

    try {
      setMainChar(design.getRobotSprite());
      setWallLayer(design.getRobotFacility1());
      addDialogSensor(new InitialDialog(this));

      setupChapter();
      layerManager.append(design.getChao());
    } catch (IOException e) {
      e.printStackTrace();
    }
    addDialogSensor(new EndLevelSensor(this));
  }

  public void update(long dt) {
    int keyState = getKeyStates();

    updateMainSprite(dt, keyState);
    updateEnemies(dt);
    updatePowers(dt, keyState);
    updateAttackSensors(dt, keyState);
    updateDialogSensors(dt, keyState);
    updateViewWindow();
  }
}
