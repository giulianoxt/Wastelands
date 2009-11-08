package game.base;

import java.util.Vector;
import game.chapters.RobotFacilityAChapter;

public class ChapterStore {
  public static Vector getStoredChapters() {
    Vector chapters = new Vector(10);

    chapters.addElement(new RobotFacilityAChapter());

    return chapters;
  }
}
