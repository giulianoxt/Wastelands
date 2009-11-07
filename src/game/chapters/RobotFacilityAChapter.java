package game.chapters;

import util.Point;
import game.GameDesign;
import game.GameMidlet;
import game.sprites.MainSprite;
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
    setStartPoint(new Point(1, 6));
    setEndPoint(new Point(21, 19));

    mainSprite = new MainSprite(mainChar);
    setupLayerManager();
  }

  public void update(long dt) {
    int keyState = getKeyStates();

    updateMainSprite(dt, keyState);
    updateViewWindow();
  }
}
