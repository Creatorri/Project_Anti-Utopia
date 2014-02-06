
package world;

import entity.Entity;
import entity.EntityType;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Torri
 */
public class Level {
    public static final int SIZE = 100;
    public TileType[][] world = new TileType[SIZE][SIZE];
    public int[][] worldDamage = new int[SIZE][SIZE];
    public ArrayList<Entity> ents = new ArrayList<>();
    public entity.Player p;
    private final Random rand = new Random();
    private final TileType[] ores = {TileType.STONE,TileType.COAL,TileType.AIR,TileType.STEEL,TileType.URANIUM};
    public Level(){
        for(int x=0;x<SIZE;x++){
            for(int y=0;y<SIZE;y++){
                world[x][y] = TileType.STONE;
            }
        }
        System.out.println("Generating World...");
        for(int i=0;i<rand.nextInt(SIZE/2);i++){
            generateMineshaft(rand.nextInt(SIZE),rand.nextInt(SIZE));
        }
        for(int i=0;i<rand.nextInt(SIZE)+10;i++){
            generateCave(rand.nextInt(SIZE),rand.nextInt(SIZE));
        }
        for(int i=0;i<rand.nextInt(SIZE);i++){
            generateOres(rand.nextInt(SIZE),rand.nextInt(SIZE));
        }
        generateTemple(rand.nextInt(SIZE-25),rand.nextInt(SIZE-25));
        System.out.println("World Generated. Populating the world...");
        populate();
        setTileDamage();
        p = new entity.Player(this);
        System.out.println("Population Complete. Level Generated.");
    }
    public void generateMineshaft(int x,int y){
        int length = rand.nextInt(SIZE/2);
        boolean up = rand.nextBoolean(); // false if in left-right 
        for(int i=x;i<length+x;i++){
            if(i>=SIZE || y+1>=SIZE || y+2>=SIZE) return;
            if(up){
                world[y][i] = TileType.WOOD;
                world[y+1][i] = TileType.AIR;
                world[y+2][i] = TileType.WOOD;
            }else{
                world[i][y] = TileType.WOOD;
                world[i][y+1] = TileType.AIR;
                world[i][y+2] = TileType.WOOD;
            }
        }
    }
    public void generateCave(int x,int y){
        int sizex = rand.nextInt(19)+1;
        int sizey = rand.nextInt(19)+1;
        for(int i=x;i<sizex+x;i++){
            for(int j=y;j<sizey+y;j++){
                if(i>=SIZE || j>=SIZE) continue;
                if(rand.nextInt(30)>5){
                    world[i][j] = TileType.AIR;
                }else{
                    world[i][j] = TileType.STONE;
                }
            }
        }
    }
    public void generateTemple(int x,int y){
        int size = 15;
        for(int i=x;i<size+x;i++){
            world[i][y] = TileType.TEMPLE_WALL;
            world[i][y+size] = TileType.TEMPLE_WALL;
            for(int j=y+1;j<size+y;j++){
                world[i][j] = TileType.AIR;
            }
        }
        for(int i=y;i<=size+y;i++){
            world[x][i] = TileType.TEMPLE_WALL;
            world[x+size][i] = TileType.TEMPLE_WALL;
        }
    }
    public void generateOres(int x,int y){
        TileType t = ores[rand.nextInt(ores.length)];
        int size = 3;
        for(int i=x;i<size+x;i++){
            for(int j=y;j<size+y;j++){
                if(i>=SIZE || j>=SIZE) continue;
                if(rand.nextInt(30)>5){
                    world[i][j] = t;
                }
            }
        }
    }
    public void populate(){
        int e = 0;
        for(int i=0;i<rand.nextInt(30)+1;i++){
            e = rand.nextInt(EntityType.values().length-1);
            while(e==6){
                e = rand.nextInt(EntityType.values().length-1);
            }
            ents.add(new Entity(EntityType.values()[e],this));
        }
    }
    public void setTileDamage(){
        for(int xx=0;xx<SIZE;xx++){
            for(int yy=0;yy<SIZE;yy++){
                switch(world[xx][yy]){
                    case STONE:
                        worldDamage[xx][yy]=10;
                        break;
                    case WOOD:
                        worldDamage[xx][yy]=5;
                        break;
                    case STEEL:
                        worldDamage[xx][yy]=15;
                        break;
                    case URANIUM:
                        worldDamage[xx][yy]=30;
                        break;
                    case COAL:
                        worldDamage[xx][yy]=12;
                        break;
                    case DIRT:
                        worldDamage[xx][yy]=3;
                        break;
                    case AIR:
                        worldDamage[xx][yy]=0;
                        break;
                    default:
                        worldDamage[xx][yy]=2;
                        break;
                }
            }
        }
    }
}
