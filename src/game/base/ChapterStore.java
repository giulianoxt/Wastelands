package game.base;

import java.util.Vector;

public class ChapterStore {
  public static Vector getStoredChapters() {
    Vector chapters = new Vector();

    chapters.addElement(
      new ChapterDescriptor("robot_facility_a", "Robot Facility A")
    );

    chapters.addElement(
      new ChapterDescriptor("robot_facility_b", "Robot Facility B")
    );

    chapters.addElement(
      new ChapterDescriptor("robot_facility_1", "Robot Facility 1")
    );

    chapters.addElement(
      new ChapterDescriptor("robot_facility_2", "Robot Facility 2")
    );
    
    chapters.addElement(
      new ChapterDescriptor("robot_facility_3", "Robot Facility 3")
    );

    return chapters;
  }
}
