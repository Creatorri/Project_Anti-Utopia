
package assets;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
        } catch (Exception ex) {}
    }
    public synchronized void stopSound(){
        if(clip!=null){
            clip.stop();
        }
    }
}
