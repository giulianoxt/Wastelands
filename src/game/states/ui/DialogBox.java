package game.states.ui;


import game.base.State;
import game.attacks.AttackSensor;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import properties.Constants;
import util.Util;

public class DialogBox extends State {
  public DialogBox(String msg, State state) {
    message = msg;
    oldState = state;
    dialogImg = Util.getImage("/sprites/dialog.png");
    elapsed = 0;
  }

  public void update(long dt) {
    elapsed += dt;

    if (AttackSensor.firePressed(getKeyStates()) ||
        elapsed >= Constants.DIALOG_DURATION)
      game.gotoState(oldState);
  }

  public void draw(Graphics g) {
    oldState.draw(g);

    g.drawImage(
      dialogImg,
      Constants.SCREEN_WIDTH / 2,
      Constants.SCREEN_HEIGHT / 2,
      Graphics.HCENTER | Graphics.VCENTER
    );

    Font oldFont = g.getFont();

    Font newFont = Font.getFont(
      Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL
    );

    g.setFont(newFont);
    g.drawString(
      message,
      Constants.SCREEN_WIDTH / 2,
      Constants.SCREEN_HEIGHT / 2,
      Graphics.HCENTER | Graphics.BASELINE
    );
    g.setFont(oldFont);
  }

  private long elapsed;
  private String message;
  private State oldState;
  private Image dialogImg;
}
