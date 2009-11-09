package game.dialogs;

import game.chapters.Chapter;
import game.states.ui.DialogBox;

public class InitialDialog extends DialogSensor {
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
      activate(new DialogBox(chapter.getName(), chapter));
    }
  }

  private long elapsed;
  private boolean done;
}