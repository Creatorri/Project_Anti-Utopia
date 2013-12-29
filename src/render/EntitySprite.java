
package render;

import entity.EntityType;
import java.awt.image.BufferedImage;
import assets.LoadArt;

/**
 *
 * @author Torri
 */
public class EntitySprite {
    private LoadArt la = new LoadArt();
    private BufferedImage spritesheet =  la.createBufferedImage("entities.png");
    public BufferedImage i = new BufferedImage(64,64,BufferedImage.TYPE_4BYTE_ABGR);
    public EntitySprite(EntityType e){
        switch(e){
            case SNAKE:
                i = spritesheet.getSubimage(0, 0, 64, 64);
                break;
            case GOBLIN:
                i = spritesheet.getSubimage(0, 64, 64, 64);
                break;
            case GHOST:
                i = spritesheet.getSubimage(0, 128, 64, 64);
                break;
            case TROLL:
                i = spritesheet.getSubimage(64, 64, 64, 64);
                break;
            case BEHEMOTH:
                i = spritesheet.getSubimage(64, 128, 64, 64);
                break;
            case DRAGON:
                i = spritesheet.getSubimage(128, 64, 128, 128);
                break;
            case SPIDER:
                i = spritesheet.getSubimage(0, 128, 64, 64);
                break;
        }
    }
}
