package game.chapters;

import util.Point;
import game.base.State;
import game.sprites.MainSprite;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.TiledLayer;

public abstract class Chapter extends State {
  public Chapter(String id, String name) {
    chapterId = id;
    chapterName = name;
  }

  public String getId() {
    return chapterId;
  }

  public String getName() {
    return chapterName;
  }

  public Point getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(Point endPoint) {
    this.endPoint = endPoint;
  }

  public Point getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(Point startPoint) {
    this.startPoint = startPoint;
  }

  public TiledLayer getWallLayer() {
    return wallLayer;
  }

  public void setWallLayer(TiledLayer wallLayer) {
    this.wallLayer = wallLayer;
  }

  protected void setupLayerManager() {
    layerManager = new LayerManager();
    layerManager.setViewWindow(0, 0, 240, 310);

    layerManager.append(mainSprite);
    layerManager.append(wallLayer);

    mainSprite.setPosition(fromLayerToScene(getStartPoint()));
  }

  protected void updateMainSprite(long dt, int keyState) {
    Point old_pos = new Point(mainSprite.getX(), mainSprite.getY());

    mainSprite.update(dt, keyState);

    if (mainSprite.collidesWith(wallLayer, false)) {
      mainSprite.setPosition(old_pos);
    }
  }

  protected void updateViewWindow() {
    int view_w = 240, view_h = 310;
    int view_w2 = view_w / 2, view_h2 = view_h / 2;

    int main_x = mainSprite.getX(), main_y = mainSprite.getY();
    int scene_w = wallLayer.getWidth(), scene_h = wallLayer.getHeight();

    int min_x = main_x - view_w2, max_x = main_x + view_w2;
    int min_y = main_y - view_h2, max_y = main_y + view_h2;

    int viewc_x, viewc_y;

    if (min_x < 0) {
      viewc_x = view_w2;
    } else if (max_x > scene_w) {
      viewc_x = scene_w - view_w2;
    } else {
      viewc_x = main_x;
    }

    if (min_y < 0) {
      viewc_y = view_h2;
    } else if (max_y > scene_h) {
      viewc_y = scene_h - view_h2;
    } else {
      viewc_y = main_y;
    }

    int viewc_tx = viewc_x - view_w2;
    int viewc_ty = viewc_y - view_h2;

    layerManager.setViewWindow(viewc_tx, viewc_ty, view_w, view_h);
  }

  protected Point fromLayerToScene(Point p) {
    return new Point(
      p.getX() * wallLayer.getCellWidth(),
      p.getY() * wallLayer.getCellHeight()
    );
  }

  public void draw(Graphics g) {
    g.setColor(0, 0, 0);
    g.fillRect(0, 0, wallLayer.getWidth(), wallLayer.getHeight());
    layerManager.paint(g, 0, 0);
  }

  protected String chapterId, chapterName;
  
  protected Point startPoint, endPoint;
  protected TiledLayer wallLayer;

  protected MainSprite mainSprite;
  protected LayerManager layerManager;
}
