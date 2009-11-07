package game.states.ui;

import game.GameDesign;
import game.base.State;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import properties.Constants;

public class MainMenu extends State {
  private GameDesign gameDesign;
  private LayerManager layerManager;

  private Sprite[] menuItems;
  private int selectedItem;

  private static MainMenu instance = null;

  public static MainMenu getInstance() {
    if (instance == null)
      instance = new MainMenu();
    
    return instance;
  }

  private MainMenu() {
    instance = this;

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
      layerManager.setViewWindow(
        0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT
      );

      selectedItem = -1;
      setSelectedItem(0);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.out.println("MainMenu()");
    }
  }

  private void setSelectedItem(int menuItem) {
    try {
    if (selectedItem != -1)
      menuItems[selectedItem].setFrame(0);

    selectedItem = menuItem;
    menuItems[menuItem].setFrame(1);
    } catch (IllegalArgumentException e) {
      System.out.println("setSelectedItem");
    }
  }

  protected void keyPressed(int keyCode) {
    int next = selectedItem;

    try {
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
    } catch (IllegalArgumentException e) {
      System.out.println("keyPressed");
    }
  }

  private void selectedAction() {
    try {
    switch (selectedItem) {
      case 0:
        game.gotoDisplayable(ChapterSelection.getInstance());
        break;

      case 1:
      case 2:
      case 3:
        game.gotoDisplayable(new MessageBox(
          "Wastelands", "Not available yet.", this
        ));
        break;

      case 4:
        game.quit();
        break;
    }
    } catch (IllegalArgumentException e) {
      System.out.println("selectedAction()");
    }
  }

  public void draw(Graphics g) {
    try {
    layerManager.paint(g, 0, 0);
    } catch (IllegalArgumentException e) {
      System.out.println("draw()");
    }
  }
}
