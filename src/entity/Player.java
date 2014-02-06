
package entity;

import render.PlayerSheet;
import render.Sprite;
import world.Level;
import world.TileType;

/**
 *
 * @author Torri
 */
public class Player extends Entity{
    public Player(Level l1) {
        super(EntityType.PLAYER,l1);
        sp=new Sprite(PlayerSheet.DOWN);
    }
    @Override
    public void move(int dx,int dy){
        if(x+dx>=Level.SIZE || y+dy>=Level.SIZE || x+dx<=0 || y+dy<=0 || (l.world[x+dx][y+dy] != TileType.AIR && l.world[x+dx][y+dy] != TileType.FIRE && l.world[x+dx][y+dy] != TileType.TORCH)){
            l.worldDamage[x+dx][y+dy]-=1;
        }else{
            x+=dx;
            y+=dy;
        }
    }
    @Override
    public void update(){
        
    }
}
