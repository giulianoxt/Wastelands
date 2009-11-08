package game.chapters;

import game.GameDesign;
import game.GameMidlet;
import game.dialogs.DialogSensor;
import game.states.ui.DialogBox;
import java.io.IOException;

public class RobotFacilityAChapter extends Chapter {
  public RobotFacilityAChapter() {
    super("robot_facility_a", "Robot Facility A");

    GameDesign design = GameMidlet.getDesignInstance();

    try {
      setMainChar(design.getMainSprite());
      setWallLayer(design.getRobotFacilityA());
      addDialogSensor(new InitialDialog(this));
    } catch (IOException e) {
      e.printStackTrace();
    }

    setupChapter();
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

  private class InitialDialog extends DialogSensor {
    public InitialDialog(Chapter c) {
      super(c);
      elapsed = 0;
      done = false;
    }

    public void update(long dt, int keyState) {
      if (done) return;

      elapsed += dt;

      if (elapsed >= 1000) {
        done = true;
        activate(new DialogBox("Where am I?", chapter));
      }
    }

    private long elapsed;
    private boolean done;
  }
}
