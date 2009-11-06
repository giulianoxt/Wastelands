package states.ui;

import states.base.*;
import states.ui.ChapterSelection;
import game.GameDesign;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

public class MainMenu extends State {
  private GameDesign gameDesign;
  private LayerManager layerManager;

  private Sprite[] menuItems;
  private int selectedItem;

  public MainMenu() {
    try {
      gameDesign = new GameDesign();
      layerManager = new LayerManager();

      menuItems = new Sprite[5];
      menuItems[0] = gameDesign.getMenuItemPlay();
      menuItems[1] = gameDesign.getMenuItemUpdate();
      menuItems[2] = gameDesign.getMenuItemScores();
      menuItems[3] = gameDesign.getMenuItemAbout();
      menuItems[4] = gameDesign.getMenuItemExit();

      gameDesign.updateLayerManagerForMainMenu(layerManager);
      layerManager.setViewWindow(0, 0, 240, 300);

      selectedItem = -1;
      setSelectedItem(0);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void setSelectedItem(int menuItem) {
    if (selectedItem != -1)
      menuItems[selectedItem].setFrame(0);

    selectedItem = menuItem;
    menuItems[menuItem].setFrame(1);
  }

  protected void keyPressed(int keyCode) {
    int next = selectedItem;

    switch (getGameAction(keyCode)) {
      case FIRE:
        selectedAction();
        return;

      case UP:
      case LEFT:
        next = (next-1) >= 0 ? (next-1) : 4;
        break;

      case DOWN:
      case RIGHT:
        next = (next + 1) % 5;
        break;
    }

    setSelectedItem(next);
  }

  private void selectedAction() {
    switch (selectedItem) {
      case 0:
        game.gotoDisplayable(new ChapterSelection());
        break;

      case 1:
      case 2:
      case 3:
        MessageBox msg = new MessageBox(
          "Wastelands", "Not available yet.", this
        );
        game.gotoDisplayable(msg);
        break;

      case 4:
        game.quit();
    }
  }

  public void draw(Graphics g) {
    layerManager.paint(g, 0, 0);
  }
}