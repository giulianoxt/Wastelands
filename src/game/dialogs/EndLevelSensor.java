package game.dialogs;

import game.GameMidlet;
import game.chapters.Chapter;
import game.fx.Sound;
import game.sprites.MainSprite;
import game.states.ui.ChapterSelection;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;
import util.Point;

public class EndLevelSensor extends DialogSensor {
  public EndLevelSensor(Chapter c) {
    super(c);

    int d = 8;
    endDoor = new Sprite(Image.createImage(48+d, 48+d));

    Point p = c.fromLayerToScene(c.getEndPoint());
    endDoor.setPosition(p.getX()-d, p.getY()-d);
  }

  public void update(long dt, int keyState) {
    MainSprite sprite = chapter.getMainSprite();

    if (sprite.collidesWith(endDoor, false) || sprite.getHP() == 0) {
      Sound.stopLoop();
      
      GameMidlet.getInstance().gotoDisplayable(
        ChapterSelection.getInstance()
      );
    }
  }

  private Sprite endDoor;
}
