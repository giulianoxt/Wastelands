package util;

public class Point {
  public Point() {
    this(0, 0);
  }

  public Point(int _x, int _y) {
    x = _x;
    y = _y;
  }

  public int getX() {
    return x;
  }

  public void setX(int _x) {
    x = _x;
  }

  public int getY() {
    return y;
  }

  public void setY(int _y) {
    y = _y;
  }

  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  private int x, y;
}
