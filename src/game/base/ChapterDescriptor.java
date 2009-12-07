package game.base;

import game.chapters.*;

public class ChapterDescriptor {
  public String id, name;

  public ChapterDescriptor(String i, String n) {
    id = i;
    name = n;
  }

  public Chapter getChapter() {
    if (id.equals("robot_facility_1"))
      return new RobotFacility1();
    else if (id.equals("robot_facility_2"))
      return new RobotFacility2();
    else if (id.equals("robot_facility_3"))
      return new RobotFacility3();
    else if (id.equals("robot_facility_a"))
      return new RobotFacilityAChapter();
    else if (id.equals("robot_facility_b"))
      return new RobotFacilityBChapter();
    else
      return null;
  }
}
