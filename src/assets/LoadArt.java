
package assets;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Torri
 */
public class LoadArt {
    public Image createImage(String path, int sizeX, int sizeY) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon ii = new ImageIcon(imgURL, "Image");
            Image i = ii.getImage();
            i=i.getScaledInstance(sizeX, sizeY, Image.SCALE_SMOOTH);
            return i;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public BufferedImage createBufferedImage(String path){
        URL imgurl = getClass().getResource(path);
        if(imgurl!=null){
            try {
                return ImageIO.read(imgurl);
            } catch (IOException ex) {
                System.err.println("Could not find file1: "+path);
            }
        }else{
            System.err.println("Could not find file2: "+path);
            return null;
        }
        return null;
    }
    public boolean exists(String path){
        URL imgurl = getClass().getResource(path);
        if(imgurl!=null){
            try {
                ImageIO.read(imgurl);
            } catch (IOException ex) {
                return false;
            }
            return true;
        }else{
            System.err.println("Could not find file2: "+path);
            return false;
        }
    }
}
