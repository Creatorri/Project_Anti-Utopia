
package render;

import entity.EntityType;
import java.awt.image.BufferedImage;
import assets.LoadArt;
import world.TileType;

/**
 *
 * @author Torri
 */
public class Sprite {
    private LoadArt la = new LoadArt();
    private BufferedImage spritesheet;
    public BufferedImage i = new BufferedImage(64,64,BufferedImage.TYPE_4BYTE_ABGR);
    public Sprite(enum e){
        if(e instanceof TileType){
            if(!la.exists("blocks.png")) return;
            spritesheet =  la.createBufferedImage("blocks.png");
            switch((TileType) e){
                case STONE:
                    i = spritesheet.getSubimage(0, 0, 64, 64);
                    break;
                case COAL:
                    i =  spritesheet.getSubimage(0, 64, 64, 64);
                    break;
                case CHEST:
                    i = spritesheet.getSubimage(0, 128, 64, 64);
                    break;
                case DIRT:
                    i = spritesheet.getSubimage(64, 0, 64, 64);
                    break;
                case STEEL:
                    i = spritesheet.getSubimage(64, 64, 64, 64);
                    break;
                case TORCH:
                    i = spritesheet.getSubimage(64, 128, 64, 64);
                    break;
                case WOOD:
                    i = spritesheet.getSubimage(128, 0, 64, 64);
                    break;
                case URANIUM:
                    i = spritesheet.getSubimage(128, 64, 64, 64);
                    break;
                case FIRE:
                    i = spritesheet.getSubimage(128, 128, 64, 64);
                    break;
                case AIR:
                    i = spritesheet.getSubimage(192, 0, 64, 64);
                    break;
                case TEMPLE_WALL:
                    i = spritesheet.getSubimage(192, 64, 64, 64);
                    break;
                default:
                    i = spritesheet;
                    break;
            }
        }else if(e instanceof EntityType){
            if(!la.exists("entities.png")) return;
            spritesheet =  la.createBufferedImage("entities.png");
            switch((EntityType) e){
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
        }else if(e instanceof PlayerSheet){
            if(!la.exists("player.png")){
                
            }
        }else{
            throw new Exception("Error: Wrong Enum Type!");
        }
    }
}
