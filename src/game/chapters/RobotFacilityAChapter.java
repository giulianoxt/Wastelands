package game.chapters;

import game.GameDesign;
import game.GameMidlet;
import game.dialogs.EndLevelSensor;
import game.dialogs.InitialDialog;
import game.sprites.EnemySprite;
import java.io.IOException;

public class RobotFacilityAChapter extends Chapter {
  public RobotFacilityAChapter() {
    super("robot_facility_a", "Robot Facility A");

    GameDesign design = GameMidlet.getDesignInstance();

    try {
      setMainChar(design.getRobotSprite());
      setWallLayer(design.getRobotFacilityA());
      addDialogSensor(new InitialDialog(this));

      girlSprite = new EnemySprite(
        design.getGirlRobotSprite(),
        design.GirlRobotWalkUp, design.GirlRobotWalkDown,
        design.GirlRobotWalkLeft, design.GirlRobotWalkRight
      );

      enemies.addElement(girlSprite);
    } catch (IOException e) {
      e.printStackTrace();
    }

    setupChapter();
    girlSprite.setPosition(50, 50);

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
