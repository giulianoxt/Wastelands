package game.fx;

import java.io.InputStream;
import javax.microedition.media.*;
import javax.microedition.media.control.VolumeControl;

public class Sound {
  private static Player background = null;

  public static void playLoop(String filename) {
    stopLoop();

    try {
      filename = "/songs/" + filename;
      String type = "audio/midi";

      System.out.println("filename = " + filename);
      InputStream input = Sound.class.getResourceAsStream(filename);
      background = Manager.createPlayer(input, type);
      background.prefetch();

      Control[] controls = background.getControls();
      for (int i = 0; i < controls.length; ++i) {
        Control c = controls[i];
        if (c instanceof VolumeControl) {
          ((VolumeControl)c).setLevel(20);
          break;
        }
      }

      background.setLoopCount(-1);      
      background.start();
    } catch (Exception e) { }
  }

  public static void stopLoop() {
    try { background.stop(); } catch (Exception e) { }
  }
}
