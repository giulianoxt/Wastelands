package game.states;

import util.Point;
import game.base.State;
import javax.microedition.lcdui.game.TiledLayer;

public class Chapter extends State {
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

  protected String chapterId, chapterName;

  protected TiledLayer wallLayer;
  protected Point startPoint, endPoint;
}
