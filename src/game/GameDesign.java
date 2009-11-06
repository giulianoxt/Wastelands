package game;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * @author Usuario
 */
public class GameDesign {

  //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
  private Image menu_background;
  private Sprite MenuBackgorund;
  public int StillDelay = 200;
  public int[] Still = {0};
  private Image menu_about;
  private Sprite MenuItemAbout;
  public int MenuItemAboutAnimDelay = 200;
  public int[] MenuItemAboutAnim = {0, 1};
  private Image menu_exit;
  private Sprite MenuItemExit;
  public int MenuItemExitAnimDelay = 200;
  public int[] MenuItemExitAnim = {0, 1};
  private Image menu_play;
  private Sprite MenuItemPlay;
  public int MenuItemPlayAnimDelay = 200;
  public int[] MenuItemPlayAnim = {0, 1};
  private Image menu_scores;
  private Sprite MenuItemScores;
  public int MenuItemScoreAnimDelay = 200;
  public int[] MenuItemScoreAnim = {0, 1};
  private Image menu_update;
  private Sprite MenuItemUpdate;
  public int MenuItemUpdateAnimDelay = 200;
  public int[] MenuItemUpdateAnim = {0, 1};
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
    getMenuBackgorund().setPosition(0, 0);
    getMenuBackgorund().setVisible(true);
    lm.append(getMenuBackgorund());//GEN-END:|1-updateLayerManager|1|1-postUpdate
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

  public Sprite getMenuBackgorund() throws java.io.IOException {//GEN-BEGIN:|3-getter|0|3-preInit
    if (MenuBackgorund == null) {//GEN-END:|3-getter|0|3-preInit
      // write pre-init user code here
      MenuBackgorund = new Sprite(getMenu_background(), 240, 300);//GEN-BEGIN:|3-getter|1|3-postInit
      MenuBackgorund.setFrameSequence(Still);//GEN-END:|3-getter|1|3-postInit
      // write post-init user code here
    }//GEN-BEGIN:|3-getter|2|
    return MenuBackgorund;
  }
//GEN-END:|3-getter|2|

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

}
