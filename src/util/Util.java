package util;

import java.io.IOException;
import javax.microedition.lcdui.Image;

public class Util {
  public static Image getImage(String filepath) {
    try {
      return Image.createImage(filepath);
    } catch (IOException e) {
      return null;
    }
  }
}
