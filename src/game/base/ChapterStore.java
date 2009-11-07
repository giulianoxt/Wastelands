package game.base;

import game.chapters.Chapter;
import game.chapters.RobotFacilityAChapter;

public class ChapterStore {
  public static Chapter[] getStoredChapters() {
    Chapter[] chapters = new Chapter[1];

    chapters[0] = new RobotFacilityAChapter();

    return chapters;
  }
}
