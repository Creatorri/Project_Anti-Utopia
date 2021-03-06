
package entity;

import assets.LoadArt;
import java.util.Random;
import render.Sprite;
import util.AI;
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
    AI ai;
    public double health=20,maxhealth=20;
    public EntityType t;
    public Sprite sp;
    public Entity(EntityType t1,Level l1){
        t=t1;
        l=l1;
        sp = new Sprite(t1);
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
                break;
            default:
                health=20;
                break;
        }
        maxhealth=health;
        spawn();
        ai= new AI(this,20);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    /**
     * Gets the distance to an entity
     * @param e
     * @return
     */
    public double distTo(Entity e){
        return Math.sqrt(((x-e.x)*(x-e.x))+((y-e.y)*(y-e.y)));
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
        if(x+dx>=Level.SIZE || y+dy>=Level.SIZE || x+dx<=0 || y+dy<=0 || (l.world[x+dx][y+dy] != TileType.AIR && l.world[x+dx][y+dy] != TileType.FIRE && l.world[x+dx][y+dy] != TileType.TORCH)){
        }else{
            x+=dx;
            y+=dy;
        }
    }
    public void update(){
        int[] move = ai.pointTowards(l.p);
        move(move[0],move[1]);
    }
}
