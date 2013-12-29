
package entity;

import assets.LoadArt;
import java.util.Random;
import world.Level;
import world.TileType;

/**
 *
 * @author Torri
 */
public class Entity {
    Random rand = new Random();
    LoadArt la = new LoadArt();
    Level l;
    int x,y;
    public int size=64;
    public double health=20,maxhealth=20;
    public EntityType t;
    public Entity(EntityType t1,Level l1){
        t=t1;
        l=l1;
        switch(t){
            case BAT:
                health=15;
                break;
            case PLAYER:
                health=25;
                break;
            case SNAKE:
                health=25;
                break;
            case SPIDER:
                health=35;
                break;
            case GOBLIN:
                health=75;
                break;
            case TROLL:
                health=150;
                break;
            case GHOST:
                health=190;
                break;
            case BEHEMOTH:
                health=270;
                break;
            case DRAGON:
                health=500;
                size=128;
                break;
            default:
                health=20;
                break;
        }
        maxhealth=health;
        spawn();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void spawn(){
        x=rand.nextInt(Level.SIZE);
        y=rand.nextInt(Level.SIZE);
        while(l.world[x][y]!=TileType.AIR && l.world[x][y]!=TileType.FIRE && l.world[x][y]!=TileType.TORCH){
            x=rand.nextInt(Level.SIZE);
            y=rand.nextInt(Level.SIZE);
        }
    }
    public void move(int dx,int dy){
        if(x+dx>=Level.SIZE || y+dy>=Level.SIZE || x+dx<=0 || y+dy<=0 || !(l.world[x+dx][y+dy] == TileType.AIR || l.world[x+dx][y+dy] == TileType.FIRE || l.world[x+dx][y+dy]==TileType.TORCH)){
        }else{
            System.out.println("Motion");
            x+=dx;
            y+=dy;
        }
    }
    public void update(){
        move((rand.nextInt(2)-1),(rand.nextInt(2)-1));
    }
}
