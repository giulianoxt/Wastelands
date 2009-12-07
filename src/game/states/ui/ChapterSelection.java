package game.states.ui;

import util.Util;
import game.GameMidlet;
import game.base.ChapterDescriptor;
import game.base.ChapterStore;
import game.chapters.Chapter;
import java.util.Vector;
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

    Vector chapters = ChapterStore.getStoredChapters();
    
    for (int i = 0; i < chapters.size(); ++i) {
      append(getChapterItem((ChapterDescriptor)chapters.elementAt(i)));
    }

    addCommand(new Command("Back", Command.CANCEL, 2));

    setCommandListener(new CommandListener() {
      public void commandAction(Command c, Displayable d) {
        if (c.getCommandType() == Command.CANCEL)
          GameMidlet.getInstance().gotoState(MainMenu.getInstance());
      }
    });
  }

  private ImageItem getChapterItem(final ChapterDescriptor chapterD) {
    String filepath = "/chapters/" + chapterD.id + "/thumbnail.png";
    Image image = Util.getImage(filepath);

    ImageItem item = new ImageItem(
      chapterD.name, image, Item.LAYOUT_CENTER, "", ImageItem.BUTTON
    );

    item.addCommand(new Command("Play", Command.OK, 1));

    item.setItemCommandListener(new ItemCommandListener() {
      public void commandAction(Command c, Item item) {
        if (c.getCommandType() == Command.OK)
          GameMidlet.getInstance().gotoState(chapterD.getChapter());
      }
    });

    return item;
  }
}
