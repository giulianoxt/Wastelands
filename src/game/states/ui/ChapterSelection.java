package game.states.ui;

import util.Util;
import game.GameMidlet;
import game.base.ChapterStore;
import game.chapters.Chapter;
import javax.microedition.lcdui.*;

public class ChapterSelection extends Form {
  private static ChapterSelection instance = null;

  public static ChapterSelection getInstance() {
    if (instance == null)
      instance = new ChapterSelection();

    return instance;
  }

  private ChapterSelection() {
    super("Chapter selection");
    instance = this;

    Chapter[] chapters = ChapterStore.getStoredChapters();
    
    for (int i = 0; i < chapters.length; ++i) {
      append(getChapterItem(chapters[i]));
    }

    addCommand(new Command("Back", Command.CANCEL, 2));

    setCommandListener(new CommandListener() {
      public void commandAction(Command c, Displayable d) {
        if (c.getCommandType() == Command.CANCEL)
          GameMidlet.getInstance().gotoState(MainMenu.getInstance());
      }
    });
  }

  private ImageItem getChapterItem(final Chapter chapter) {
    String filepath = "/chapters/" + chapter.getId() + "/thumbnail.png";
    Image image = Util.getImage(filepath);

    ImageItem item = new ImageItem(
      chapter.getName(), image, Item.LAYOUT_CENTER, "", ImageItem.BUTTON
    );

    item.addCommand(new Command("Play", Command.OK, 1));

    item.setItemCommandListener(new ItemCommandListener() {
      public void commandAction(Command c, Item item) {
        if (c.getCommandType() == Command.OK)
          GameMidlet.getInstance().gotoState(chapter);
      }
    });

    return item;
  }
}
