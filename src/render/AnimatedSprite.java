
package render;

import assets.LoadArt;
import java.awt.image.BufferedImage;

/**
 *
 * @author Torri
 */
public class AnimatedSprite extends Sprite{
    BufferedImage[] frames;
    public <E extends Enum<E>> AnimatedSprite(E e) {
        super(e);
        if(!(e instanceof PlayerSheet)) return;
        LoadArt la= new LoadArt();
        
    }
}
