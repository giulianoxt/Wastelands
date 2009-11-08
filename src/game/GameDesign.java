package game;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

/**
 * @author Usuario
 */
public class GameDesign {

  //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
  private Image menu_background;
  private Sprite MenuBackground;
  public int MenuBackgroundseq001Delay = 200;
  public int[] MenuBackgroundseq001 = {0, 0, 0, 0, 0};
  private Image menu_about;
  private Sprite MenuItemAbout;
  public int MenuItemAboutAnimDelay = 200;
  public int[] MenuItemAboutAnim = {0, 1};
  private Image robot_facility_tileset;
  private Image menu_exit;
  private Sprite MenuItemExit;
  public int MenuItemExitAnimDelay = 200;
  public int[] MenuItemExitAnim = {0, 1};
  private Image splash_wastelands;
  private Image menu_play;
  private Image robot_facility_tileset_4;
  private Sprite MenuItemPlay;
  public int MenuItemPlayAnimDelay = 200;
  public int[] MenuItemPlayAnim = {0, 1};
  private TiledLayer RobotFacilityA;
  private Sprite MenuItemScores;
  public int MenuItemScoreAnimDelay = 200;
  public int[] MenuItemScoreAnim = {0, 1};
  private Image menu_scores;
  private Image menu_update;
  private Sprite MenuItemUpdate;
  public int MenuItemUpdateAnimDelay = 200;
  public int[] MenuItemUpdateAnim = {0, 1};
  private Image blue_ball;
  private Image red_ball;
  private Sprite BlueBall;
  public int BlueBallseq003Delay = 200;
  public int[] BlueBallseq003 = {0};
  private Image guard_yellow;
  private Sprite GuardYellow;
  public int GuardYelloWalkRightDelay = 200;
  public int[] GuardYelloWalkRight = {6, 7, 8};
  public int GuardYellowWalkUpDelay = 200;
  public int[] GuardYellowWalkUp = {9, 10, 11};
  public int GuardYellowWalkDownDelay = 200;
  public int[] GuardYellowWalkDown = {0, 1, 2};
  public int GuardYellowWalkLeftDelay = 200;
  public int[] GuardYellowWalkLeft = {3, 4, 5};
  private Sprite RedBall;
  public int RedBallseq001Delay = 200;
  public int[] RedBallseq001 = {0, 0, 0, 0, 0};
  private Image main;
  private Sprite MainSprite;
  public int MainWalkUpDelay = 160;
  public int[] MainWalkUp = {9, 10, 11};
  public int MainWalkRightDelay = 160;
  public int[] MainWalkRight = {6, 7, 8};
  public int MainWalkLeftDelay = 160;
  public int[] MainWalkLeft = {3, 4, 5};
  public int MainWalkDownDelay = 160;
  public int[] MainWalkDown = {0, 1, 2};
  private Sprite GuardGreen;
  public int GuardGreenWalkLeftDelay = 160;
  public int[] GuardGreenWalkLeft = {3, 4, 5};
  public int GuardGreenWalkDownDelay = 160;
  public int[] GuardGreenWalkDown = {0, 1, 2};
  public int GuardGreenWalkUpDelay = 160;
  public int[] GuardGreenWalkUp = {9, 10, 11};
  public int GuardGreenWalkRightDelay = 160;
  public int[] GuardGreenWalkRight = {6, 7, 8};
  private Image guard_green;
  private Sprite GuardPunk;
  public int GuardPunkWalkUpDelay = 160;
  public int[] GuardPunkWalkUp = {9, 10, 11};
  public int GuardPunkWalkRightDelay = 160;
  public int[] GuardPunkWalkRight = {6, 7, 8};
  public int GuardPunkWalkLeftDelay = 160;
  public int[] GuardPunkWalkLeft = {3, 4, 5};
  public int GuardPunkWalkDownDelay = 160;
  public int[] GuardPunkWalkDown = {0, 1, 2};
  private Image guard_punk;
  private Image guard_red;
  private Sprite RedMage;
  public int RedMageWalkDownDelay = 200;
  public int[] RedMageWalkDown = {0, 1, 2};
  public int RedMageWalkLeftDelay = 200;
  public int[] RedMageWalkLeft = {3, 4, 5};
  public int RedMageWalkRightDelay = 200;
  public int[] RedMageWalkRight = {6, 7, 8};
  public int RedMageWalkUpDelay = 200;
  public int[] RedMageWalkUp = {9, 10, 11};
  private Image topview_tiles;
  private Sprite SpiderMine;
  public int SpiderMineseq001Delay = 200;
  public int[] SpiderMineseq001 = {80, 81, 82, 83, 84, 86, 86, 87};
  //</editor-fold>//GEN-END:|fields|0|

  //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
  //</editor-fold>//GEN-END:|methods|0|

  public void updateLayerManagerForMainMenu(LayerManager lm) throws java.io.IOException {//GEN-LINE:|1-updateLayerManager|0|1-preUpdate
    // write pre-update user code here
    getMenuItemExit().setPosition(102, 251);//GEN-BEGIN:|1-updateLayerManager|1|1-postUpdate
    getMenuItemExit().setVisible(true);
    lm.append(getMenuItemExit());
    getMenuItemAbout().setPosition(105, 205);
    getMenuItemAbout().setVisible(true);
    lm.append(getMenuItemAbout());
    getMenuItemScores().setPosition(105, 156);
    getMenuItemScores().setVisible(true);
    lm.append(getMenuItemScores());
    getMenuItemUpdate().setPosition(105, 109);
    getMenuItemUpdate().setVisible(true);
    lm.append(getMenuItemUpdate());
    getMenuItemPlay().setPosition(105, 60);
    getMenuItemPlay().setVisible(true);
    lm.append(getMenuItemPlay());
    getMenuBackground().setPosition(0, 0);
    getMenuBackground().setVisible(true);
    lm.append(getMenuBackground());//GEN-END:|1-updateLayerManager|1|1-postUpdate
    // write post-update user code here
  }//GEN-BEGIN:|1-updateLayerManager|2|
//GEN-END:|1-updateLayerManager|2|

  public Image getMenu_background() throws java.io.IOException {//GEN-BEGIN:|2-getter|0|2-preInit
    if (menu_background == null) {//GEN-END:|2-getter|0|2-preInit
      // write pre-init user code here
      menu_background = Image.createImage("/menu_background.png");//GEN-BEGIN:|2-getter|1|2-postInit
    }//GEN-END:|2-getter|1|2-postInit
    // write post-init user code here
    return this.menu_background;//GEN-BEGIN:|2-getter|2|
  }
//GEN-END:|2-getter|2|



  public Image getMenu_about() throws java.io.IOException {//GEN-BEGIN:|6-getter|0|6-preInit
    if (menu_about == null) {//GEN-END:|6-getter|0|6-preInit
      // write pre-init user code here
      menu_about = Image.createImage("/menu_about.png");//GEN-BEGIN:|6-getter|1|6-postInit
    }//GEN-END:|6-getter|1|6-postInit
    // write post-init user code here
    return this.menu_about;//GEN-BEGIN:|6-getter|2|
  }
//GEN-END:|6-getter|2|

  public Sprite getMenuItemAbout() throws java.io.IOException {//GEN-BEGIN:|7-getter|0|7-preInit
    if (MenuItemAbout == null) {//GEN-END:|7-getter|0|7-preInit
      // write pre-init user code here
      MenuItemAbout = new Sprite(getMenu_about(), 140, 50);//GEN-BEGIN:|7-getter|1|7-postInit
      MenuItemAbout.setFrameSequence(MenuItemAboutAnim);//GEN-END:|7-getter|1|7-postInit
      // write post-init user code here
    }//GEN-BEGIN:|7-getter|2|
    return MenuItemAbout;
  }
//GEN-END:|7-getter|2|

  public Image getMenu_exit() throws java.io.IOException {//GEN-BEGIN:|10-getter|0|10-preInit
    if (menu_exit == null) {//GEN-END:|10-getter|0|10-preInit
      // write pre-init user code here
      menu_exit = Image.createImage("/menu_exit.png");//GEN-BEGIN:|10-getter|1|10-postInit
    }//GEN-END:|10-getter|1|10-postInit
    // write post-init user code here
    return this.menu_exit;//GEN-BEGIN:|10-getter|2|
  }
//GEN-END:|10-getter|2|

  public Sprite getMenuItemExit() throws java.io.IOException {//GEN-BEGIN:|11-getter|0|11-preInit
    if (MenuItemExit == null) {//GEN-END:|11-getter|0|11-preInit
      // write pre-init user code here
      MenuItemExit = new Sprite(getMenu_exit(), 140, 50);//GEN-BEGIN:|11-getter|1|11-postInit
      MenuItemExit.setFrameSequence(MenuItemExitAnim);//GEN-END:|11-getter|1|11-postInit
      // write post-init user code here
    }//GEN-BEGIN:|11-getter|2|
    return MenuItemExit;
  }
//GEN-END:|11-getter|2|

  public Image getMenu_play() throws java.io.IOException {//GEN-BEGIN:|13-getter|0|13-preInit
    if (menu_play == null) {//GEN-END:|13-getter|0|13-preInit
      // write pre-init user code here
      menu_play = Image.createImage("/menu_play.png");//GEN-BEGIN:|13-getter|1|13-postInit
    }//GEN-END:|13-getter|1|13-postInit
    // write post-init user code here
    return this.menu_play;//GEN-BEGIN:|13-getter|2|
  }
//GEN-END:|13-getter|2|

  public Sprite getMenuItemPlay() throws java.io.IOException {//GEN-BEGIN:|14-getter|0|14-preInit
    if (MenuItemPlay == null) {//GEN-END:|14-getter|0|14-preInit
      // write pre-init user code here
      MenuItemPlay = new Sprite(getMenu_play(), 140, 50);//GEN-BEGIN:|14-getter|1|14-postInit
      MenuItemPlay.setFrameSequence(MenuItemPlayAnim);//GEN-END:|14-getter|1|14-postInit
      // write post-init user code here
    }//GEN-BEGIN:|14-getter|2|
    return MenuItemPlay;
  }
//GEN-END:|14-getter|2|

  public Image getMenu_scores() throws java.io.IOException {//GEN-BEGIN:|16-getter|0|16-preInit
    if (menu_scores == null) {//GEN-END:|16-getter|0|16-preInit
      // write pre-init user code here
      menu_scores = Image.createImage("/menu_scores.png");//GEN-BEGIN:|16-getter|1|16-postInit
    }//GEN-END:|16-getter|1|16-postInit
    // write post-init user code here
    return this.menu_scores;//GEN-BEGIN:|16-getter|2|
  }
//GEN-END:|16-getter|2|

  public Sprite getMenuItemScores() throws java.io.IOException {//GEN-BEGIN:|17-getter|0|17-preInit
    if (MenuItemScores == null) {//GEN-END:|17-getter|0|17-preInit
      // write pre-init user code here
      MenuItemScores = new Sprite(getMenu_scores(), 140, 50);//GEN-BEGIN:|17-getter|1|17-postInit
      MenuItemScores.setFrameSequence(MenuItemScoreAnim);//GEN-END:|17-getter|1|17-postInit
      // write post-init user code here
    }//GEN-BEGIN:|17-getter|2|
    return MenuItemScores;
  }
//GEN-END:|17-getter|2|

  public Image getMenu_update() throws java.io.IOException {//GEN-BEGIN:|19-getter|0|19-preInit
    if (menu_update == null) {//GEN-END:|19-getter|0|19-preInit
      // write pre-init user code here
      menu_update = Image.createImage("/menu_update.png");//GEN-BEGIN:|19-getter|1|19-postInit
    }//GEN-END:|19-getter|1|19-postInit
    // write post-init user code here
    return this.menu_update;//GEN-BEGIN:|19-getter|2|
  }
//GEN-END:|19-getter|2|

  public Sprite getMenuItemUpdate() throws java.io.IOException {//GEN-BEGIN:|20-getter|0|20-preInit
    if (MenuItemUpdate == null) {//GEN-END:|20-getter|0|20-preInit
      // write pre-init user code here
      MenuItemUpdate = new Sprite(getMenu_update(), 140, 50);//GEN-BEGIN:|20-getter|1|20-postInit
      MenuItemUpdate.setFrameSequence(MenuItemUpdateAnim);//GEN-END:|20-getter|1|20-postInit
      // write post-init user code here
    }//GEN-BEGIN:|20-getter|2|
    return MenuItemUpdate;
  }
//GEN-END:|20-getter|2|

  public Image getMain() throws java.io.IOException {//GEN-BEGIN:|110-getter|0|110-preInit
    if (main == null) {//GEN-END:|110-getter|0|110-preInit
      // write pre-init user code here
      main = Image.createImage("/sprites/main.png");//GEN-BEGIN:|110-getter|1|110-postInit
    }//GEN-END:|110-getter|1|110-postInit
    // write post-init user code here
    return this.main;//GEN-BEGIN:|110-getter|2|
  }
//GEN-END:|110-getter|2|

  public Sprite getMainSprite() throws java.io.IOException {//GEN-BEGIN:|111-getter|0|111-preInit
    if (MainSprite == null) {//GEN-END:|111-getter|0|111-preInit
      // write pre-init user code here
      MainSprite = new Sprite(getMain(), 32, 32);//GEN-BEGIN:|111-getter|1|111-postInit
      MainSprite.setFrameSequence(MainWalkDown);//GEN-END:|111-getter|1|111-postInit
      // write post-init user code here
    }//GEN-BEGIN:|111-getter|2|
    return MainSprite;
  }
//GEN-END:|111-getter|2|

  public Image getGuard_green() throws java.io.IOException {//GEN-BEGIN:|116-getter|0|116-preInit
    if (guard_green == null) {//GEN-END:|116-getter|0|116-preInit
      // write pre-init user code here
      guard_green = Image.createImage("/sprites/guard_green.png");//GEN-BEGIN:|116-getter|1|116-postInit
    }//GEN-END:|116-getter|1|116-postInit
    // write post-init user code here
    return this.guard_green;//GEN-BEGIN:|116-getter|2|
  }
//GEN-END:|116-getter|2|

  public Sprite getGuardGreen() throws java.io.IOException {//GEN-BEGIN:|117-getter|0|117-preInit
    if (GuardGreen == null) {//GEN-END:|117-getter|0|117-preInit
      // write pre-init user code here
      GuardGreen = new Sprite(getGuard_green(), 32, 32);//GEN-BEGIN:|117-getter|1|117-postInit
      GuardGreen.setFrameSequence(GuardGreenWalkDown);//GEN-END:|117-getter|1|117-postInit
      // write post-init user code here
    }//GEN-BEGIN:|117-getter|2|
    return GuardGreen;
  }
//GEN-END:|117-getter|2|

  public Image getGuard_punk() throws java.io.IOException {//GEN-BEGIN:|122-getter|0|122-preInit
    if (guard_punk == null) {//GEN-END:|122-getter|0|122-preInit
      // write pre-init user code here
      guard_punk = Image.createImage("/sprites/guard_punk.png");//GEN-BEGIN:|122-getter|1|122-postInit
    }//GEN-END:|122-getter|1|122-postInit
    // write post-init user code here
    return this.guard_punk;//GEN-BEGIN:|122-getter|2|
  }
//GEN-END:|122-getter|2|

  public Sprite getGuardPunk() throws java.io.IOException {//GEN-BEGIN:|123-getter|0|123-preInit
    if (GuardPunk == null) {//GEN-END:|123-getter|0|123-preInit
      // write pre-init user code here
      GuardPunk = new Sprite(getGuard_punk(), 32, 32);//GEN-BEGIN:|123-getter|1|123-postInit
      GuardPunk.setFrameSequence(GuardPunkWalkDown);//GEN-END:|123-getter|1|123-postInit
      // write post-init user code here
    }//GEN-BEGIN:|123-getter|2|
    return GuardPunk;
  }
//GEN-END:|123-getter|2|

  public Image getRobot_facility_tileset() throws java.io.IOException {//GEN-BEGIN:|128-getter|0|128-preInit
    if (robot_facility_tileset == null) {//GEN-END:|128-getter|0|128-preInit
      // write pre-init user code here
      robot_facility_tileset = Image.createImage("/sprites/robot_facility_tileset_4.png");//GEN-BEGIN:|128-getter|1|128-postInit
    }//GEN-END:|128-getter|1|128-postInit
    // write post-init user code here
    return this.robot_facility_tileset;//GEN-BEGIN:|128-getter|2|
  }
//GEN-END:|128-getter|2|

  public Image getSplash_wastelands() throws java.io.IOException {//GEN-BEGIN:|130-getter|0|130-preInit
    if (splash_wastelands == null) {//GEN-END:|130-getter|0|130-preInit
      // write pre-init user code here
      splash_wastelands = Image.createImage("/splash_wastelands.png");//GEN-BEGIN:|130-getter|1|130-postInit
    }//GEN-END:|130-getter|1|130-postInit
    // write post-init user code here
    return this.splash_wastelands;//GEN-BEGIN:|130-getter|2|
  }
//GEN-END:|130-getter|2|

  public Image getRobot_facility_tileset_4() throws java.io.IOException {//GEN-BEGIN:|132-getter|0|132-preInit
    if (robot_facility_tileset_4 == null) {//GEN-END:|132-getter|0|132-preInit
      // write pre-init user code here
      robot_facility_tileset_4 = Image.createImage("/sprites/robot_facility_tileset_4.png");//GEN-BEGIN:|132-getter|1|132-postInit
    }//GEN-END:|132-getter|1|132-postInit
    // write post-init user code here
    return this.robot_facility_tileset_4;//GEN-BEGIN:|132-getter|2|
  }
//GEN-END:|132-getter|2|

  public TiledLayer getRobotFacilityA() throws java.io.IOException {//GEN-BEGIN:|134-getter|0|134-preInit
    if (RobotFacilityA == null) {//GEN-END:|134-getter|0|134-preInit
      // write pre-init user code here
      RobotFacilityA = new TiledLayer(23, 21, getRobot_facility_tileset_4(), 48, 48);//GEN-BEGIN:|134-getter|1|134-midInit
      int[][] tiles = {
        { 4, 9, 4, 4, 9, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 9, 4, 4, 4, 4, 4 },
        { 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 4 },
        { 4, 0, 0, 0, 4, 4, 4, 4, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 4 },
        { 4, 0, 0, 0, 4, 8, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 4 },
        { 4, 0, 0, 0, 4, 8, 8, 4, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4 },
        { 4, 0, 0, 0, 4, 8, 8, 4, 0, 0, 3, 3, 3, 3, 3, 9, 3, 3, 3, 3, 3, 3, 4 },
        { 4, 0, 3, 3, 3, 9, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 4 },
        { 4, 3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 4 },
        { 4, 3, 0, 0, 0, 0, 3, 3, 10, 10, 10, 10, 10, 10, 10, 10, 0, 0, 3, 3, 3, 3, 4 },
        { 4, 3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4 },
        { 4, 3, 0, 0, 0, 0, 3, 3, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 4 },
        { 4, 0, 0, 0, 0, 0, 3, 3, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 3, 0, 3, 4 },
        { 4, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 4 },
        { 4, 0, 3, 3, 3, 9, 3, 3, 3, 3, 3, 0, 3, 3, 9, 3, 3, 3, 3, 3, 0, 3, 4 },
        { 4, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 3, 0, 0, 0, 0, 3, 3, 3, 0, 3, 4 },
        { 4, 3, 0, 3, 0, 0, 0, 0, 3, 3, 3, 0, 3, 0, 0, 0, 0, 3, 3, 3, 0, 3, 4 },
        { 4, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4 },
        { 4, 3, 0, 3, 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4 },
        { 4, 3, 0, 3, 3, 9, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 9, 4, 3, 3, 3, 3, 4 },
        { 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        { 4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }
      };//GEN-END:|134-getter|1|134-midInit
      // write mid-init user code here
      for (int row = 0; row < 21; row++) {//GEN-BEGIN:|134-getter|2|134-postInit
        for (int col = 0; col < 23; col++) {
          RobotFacilityA.setCell(col, row, tiles[row][col]);
        }
      }
    }//GEN-END:|134-getter|2|134-postInit
    // write post-init user code here
    return RobotFacilityA;//GEN-BEGIN:|134-getter|3|
  }
//GEN-END:|134-getter|3|

  public Sprite getMenuBackground() throws java.io.IOException {//GEN-BEGIN:|140-getter|0|140-preInit
    if (MenuBackground == null) {//GEN-END:|140-getter|0|140-preInit
      // write pre-init user code here
      MenuBackground = new Sprite(getMenu_background(), 240, 310);//GEN-BEGIN:|140-getter|1|140-postInit
      MenuBackground.setFrameSequence(MenuBackgroundseq001);//GEN-END:|140-getter|1|140-postInit
      // write post-init user code here
    }//GEN-BEGIN:|140-getter|2|
    return MenuBackground;
  }
//GEN-END:|140-getter|2|

  public Image getGuard_yellow() throws java.io.IOException {//GEN-BEGIN:|178-getter|0|178-preInit
    if (guard_yellow == null) {//GEN-END:|178-getter|0|178-preInit
      // write pre-init user code here
      guard_yellow = Image.createImage("/sprites/guard_yellow.png");//GEN-BEGIN:|178-getter|1|178-postInit
    }//GEN-END:|178-getter|1|178-postInit
    // write post-init user code here
    return this.guard_yellow;//GEN-BEGIN:|178-getter|2|
  }
//GEN-END:|178-getter|2|

  public Sprite getGuardYellow() throws java.io.IOException {//GEN-BEGIN:|179-getter|0|179-preInit
    if (GuardYellow == null) {//GEN-END:|179-getter|0|179-preInit
      // write pre-init user code here
      GuardYellow = new Sprite(getGuard_yellow(), 32, 32);//GEN-BEGIN:|179-getter|1|179-postInit
      GuardYellow.setFrameSequence(GuardYellowWalkDown);//GEN-END:|179-getter|1|179-postInit
      // write post-init user code here
    }//GEN-BEGIN:|179-getter|2|
    return GuardYellow;
  }
//GEN-END:|179-getter|2|

  public Image getBlue_ball() throws java.io.IOException {//GEN-BEGIN:|184-getter|0|184-preInit
    if (blue_ball == null) {//GEN-END:|184-getter|0|184-preInit
      // write pre-init user code here
      blue_ball = Image.createImage("/sprites/blue_ball.png");//GEN-BEGIN:|184-getter|1|184-postInit
    }//GEN-END:|184-getter|1|184-postInit
    // write post-init user code here
    return this.blue_ball;//GEN-BEGIN:|184-getter|2|
  }
//GEN-END:|184-getter|2|



  public Sprite getBlueBall() throws java.io.IOException {//GEN-BEGIN:|189-getter|0|189-preInit
    if (BlueBall == null) {//GEN-END:|189-getter|0|189-preInit
      // write pre-init user code here
      BlueBall = new Sprite(getBlue_ball(), 42, 14);//GEN-BEGIN:|189-getter|1|189-postInit
      BlueBall.setFrameSequence(BlueBallseq003);//GEN-END:|189-getter|1|189-postInit
      // write post-init user code here
    }//GEN-BEGIN:|189-getter|2|
    return BlueBall;
  }
//GEN-END:|189-getter|2|

  public Image getRed_ball() throws java.io.IOException {//GEN-BEGIN:|191-getter|0|191-preInit
    if (red_ball == null) {//GEN-END:|191-getter|0|191-preInit
      // write pre-init user code here
      red_ball = Image.createImage("/sprites/red_ball.png");//GEN-BEGIN:|191-getter|1|191-postInit
    }//GEN-END:|191-getter|1|191-postInit
    // write post-init user code here
    return this.red_ball;//GEN-BEGIN:|191-getter|2|
  }
//GEN-END:|191-getter|2|

  public Sprite getRedBall() throws java.io.IOException {//GEN-BEGIN:|192-getter|0|192-preInit
    if (RedBall == null) {//GEN-END:|192-getter|0|192-preInit
      // write pre-init user code here
      RedBall = new Sprite(getRed_ball(), 42, 14);//GEN-BEGIN:|192-getter|1|192-postInit
      RedBall.setFrameSequence(RedBallseq001);//GEN-END:|192-getter|1|192-postInit
      // write post-init user code here
    }//GEN-BEGIN:|192-getter|2|
    return RedBall;
  }
//GEN-END:|192-getter|2|

  public Image getGuard_red() throws java.io.IOException {//GEN-BEGIN:|194-getter|0|194-preInit
    if (guard_red == null) {//GEN-END:|194-getter|0|194-preInit
      // write pre-init user code here
      guard_red = Image.createImage("/sprites/guard_red.png");//GEN-BEGIN:|194-getter|1|194-postInit
    }//GEN-END:|194-getter|1|194-postInit
    // write post-init user code here
    return this.guard_red;//GEN-BEGIN:|194-getter|2|
  }
//GEN-END:|194-getter|2|

  public Sprite getRedMage() throws java.io.IOException {//GEN-BEGIN:|195-getter|0|195-preInit
    if (RedMage == null) {//GEN-END:|195-getter|0|195-preInit
      // write pre-init user code here
      RedMage = new Sprite(getGuard_red(), 32, 32);//GEN-BEGIN:|195-getter|1|195-postInit
      RedMage.setFrameSequence(RedMageWalkDown);//GEN-END:|195-getter|1|195-postInit
      // write post-init user code here
    }//GEN-BEGIN:|195-getter|2|
    return RedMage;
  }
//GEN-END:|195-getter|2|

  public Image getTopview_tiles() throws java.io.IOException {//GEN-BEGIN:|200-getter|0|200-preInit
    if (topview_tiles == null) {//GEN-END:|200-getter|0|200-preInit
      // write pre-init user code here
      topview_tiles = Image.createImage("/topview_tiles.png");//GEN-BEGIN:|200-getter|1|200-postInit
    }//GEN-END:|200-getter|1|200-postInit
    // write post-init user code here
    return this.topview_tiles;//GEN-BEGIN:|200-getter|2|
  }
//GEN-END:|200-getter|2|

  public Sprite getSpiderMine() throws java.io.IOException {//GEN-BEGIN:|201-getter|0|201-preInit
    if (SpiderMine == null) {//GEN-END:|201-getter|0|201-preInit
      // write pre-init user code here
      SpiderMine = new Sprite(getTopview_tiles(), 16, 16);//GEN-BEGIN:|201-getter|1|201-postInit
      SpiderMine.setFrameSequence(SpiderMineseq001);//GEN-END:|201-getter|1|201-postInit
      // write post-init user code here
    }//GEN-BEGIN:|201-getter|2|
    return SpiderMine;
  }
//GEN-END:|201-getter|2|



}
