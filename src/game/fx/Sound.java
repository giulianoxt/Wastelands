package game.fx;

import java.io.InputStream;
import javax.microedition.media.*;
import javax.microedition.media.control.*;

public class Sound {
  private static Player background;

  static {
    background = createPlayer("dark1.mid", "audio/midi");
    background.setLoopCount(-1);
  }

  private static Player createPlayer(String filename, String type) {
    try {
      filename = "/songs/" + filename;

      InputStream input = Sound.class.getResourceAsStream(filename);
      Player p = Manager.createPlayer(input, type);
      p.prefetch();

      Control[] controls = p.getControls();
      for (int i = 0; i < controls.length; ++i) {
        Control c = controls[i];
        if (c instanceof VolumeControl) {
          ((VolumeControl)c).setLevel(4);
          break;
        }
      }

      return p;
    } catch (Exception e) { }

    return null;
  }

  public static void playLoop(String filename) {
    stopLoop();
    try { background.start(); } catch (Exception e) { }
  }

  public static void stopLoop() {
    try { background.stop(); } catch (Exception e) { }
  }
}
