package game.dialogs;

import game.GameMidlet;
import game.chapters.Chapter;
import game.states.ui.DialogBox;

public abstract class DialogSensor {
  public DialogSensor(Chapter c) {
    chapter = c;
  }

  public abstract void update(long dt, int keyState);

  protected void activate(DialogBox dialogBox) {
    GameMidlet.getInstance().gotoState(dialogBox);
  }

  protected Chapter chapter;
}
