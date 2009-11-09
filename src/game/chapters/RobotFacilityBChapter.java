package game.chapters;

import game.GameDesign;
import game.GameMidlet;
import game.dialogs.EndLevelSensor;
import game.dialogs.InitialDialog;
import game.sprites.EnemySprite;
import java.io.IOException;

public class RobotFacilityBChapter extends Chapter {
  public RobotFacilityBChapter() {
    super("robot_facility_b", "Robot Facility B");

    GameDesign design = GameMidlet.getDesignInstance();

    try {
      setMainChar(design.getRobotSprite());
      setWallLayer(design.getRobotFacilityB());
      addDialogSensor(new InitialDialog(this));
    } catch (IOException e) {
      e.printStackTrace();
    }

    setupChapter();
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

  private EnemySprite girlSprite;
}
