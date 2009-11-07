package util;

import java.io.IOException;
import java.util.Hashtable;
import javax.microedition.lcdui.Image;

public class Util {
  public static Image getImage(String filepath) {
    if (cache.containsKey(filepath)) {
      return (Image)cache.get(filepath);
    }

    try {
      Image img = Image.createImage(filepath);
      cache.put(filepath, img);
      return img;
    } catch (IOException e) {
      return null;
    }
  }

  private static Hashtable cache = new Hashtable(30);
}
