package game.states.ui;

import game.GameMidlet;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import game.base.State;

public class MessageBox extends Alert implements CommandListener {
  public MessageBox(String title, String content, State next) {
    this(title, content, next, null);
  }

  public MessageBox(String title, String content, Displayable next) {
    this(title, content, null, next);
  }

  private MessageBox(String title, String content,
          State nextSt, Displayable nextDis) {

    super(title, content, null, null);
    nextState = nextSt;
    nextDisplayable = nextDis;

    addCommand(DISMISS_COMMAND);
    setCommandListener(this);
  }

  public void commandAction(Command c, Displayable d) {
    if (c.getCommandType() == Command.OK) {
      if (nextState != null) {
        GameMidlet.getInstance().gotoState(nextState);
      }
      else if (nextDisplayable != null) {
        GameMidlet.getInstance().gotoDisplayable(nextDisplayable);
      }
    }
  }
 
  private State nextState;
  private Displayable nextDisplayable;
}
