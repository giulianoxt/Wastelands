package util;

import game.sprites.MainSprite;
import java.util.Hashtable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class Util {
  public static int getDistance2(Sprite a, Sprite b) {
    int dx = a.getX() - b.getX();
    int dy = a.getY() - b.getY();
    return dx*dx + dy*dy;
  }

  public static Image getImage(String filepath) {
    if (imageCache.containsKey(filepath)) {
      return (Image)imageCache.get(filepath);
    }

    try {
      Image img = Image.createImage(filepath);
      imageCache.put(filepath, img);
      return img;
    } catch (IOException e) {
      return null;
    }
  }

  public static void adjustPositionToMovement(
      Sprite sprite, MainSprite main, int movement) {
    int dx = 0, dy = 0;

    switch (movement) {
      case 0:
        dx = main.getWidth() - sprite.getWidth() / 2 - 4;
        dy = -(sprite.getHeight() - main.getHeight() / 2) + 6;
        break;
      case 1:
        dx = 2;
        dy = main.getHeight() / 2;
        break;
      case 2:
        dx = -(sprite.getWidth() - 10) + 4;
        dy = main.getHeight() / 2;
        break;
      case 3:
        dx = main.getWidth() / 2 + 2;
        dy = main.getHeight() / 2;
        break;
    }

    sprite.setPosition(main.getX() + dx, main.getY() + dy);
  }

  public static Hashtable readPropertyFile(String chapterId) {
    try {
      String filepath = "/chapters/" + chapterId + "/description.txt";

      InputStream input_s = Util.class.getResourceAsStream(filepath);

      InputStreamReader reader = new InputStreamReader(input_s);

      int n;
      String str = "";
      char[] buff = new char[500];

      while ((n = reader.read(buff)) != -1) {
        str += new String(buff, 0, n);
      }

      int pos = 0, npos;

      Hashtable hash = new Hashtable();

      while ((npos = str.indexOf('\n', pos)) != -1) {
        String line = str.substring(pos, npos).trim();
        pos = npos + 1;

        if (line.length() == 0)
          continue;

        int eq_pos = line.indexOf('=');
        String id = line.substring(0, eq_pos).trim();
        String val = line.substring(eq_pos+1).trim();

        hash.put(id, val);
      }

      return hash;
    } catch (IOException e) {
      return null;
    }
  }

  public static Point readTuple(String tuple) {
    tuple = tuple.replace('(', ' ').replace(')', ' ').trim();

    int comma_pos = tuple.indexOf(',');
    String x = tuple.substring(0, comma_pos).trim();
    String y = tuple.substring(comma_pos+1).trim();

    return new Point(
      Integer.valueOf(x).intValue(),
      Integer.valueOf(y).intValue()
    );
  }

  private static Hashtable imageCache = new Hashtable(30);
}
