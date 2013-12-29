
package assets;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Torri
 */
public class Audio {
    Clip clip;
    public synchronized void playSound(String url) {
        try {
            clip = AudioSystem.getClip();
            AudioInputStream ins = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(url));
            clip.open(ins);
            clip.start();
        } catch (IOException ex) {} catch (LineUnavailableException ex) {} catch (UnsupportedAudioFileException ex) {}
    }
    public synchronized void stopSound(){
        if(clip!=null){
            clip.stop();
        }
    }
}
