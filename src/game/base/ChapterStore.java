package game.base;

import java.util.Vector;
import game.chapters.RobotFacilityAChapter;
import game.chapters.RobotFacilityBChapter;

public class ChapterStore {
  public static Vector getStoredChapters() {
    Vector chapters = new Vector();

    chapters.addElement(new RobotFacilityAChapter());
    chapters.addElement(new RobotFacilityBChapter());

    return chapters;
  }
}
