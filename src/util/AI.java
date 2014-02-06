
package util;

import entity.Entity;
import java.util.List;
import java.util.Random;
import entity.Direction;

/**
 *
 * @author Torri
 */
public class AI {
    private final Entity parent;
    private final int followdist;
    private final int x,y;
    private final Random rand = new Random();
    public AI(Entity body,int follow){
        parent=body;
        x=body.getX();
        y=body.getY();
        if(follow>150){
            followdist=150;
        }else{
            followdist=follow;
        }
    }
    /**
     * basic tracer AI
     * @param e
     * @return 
     */
    public int[] pointTowards(Entity e){
        int[] dir = new int[]{0,0};
        if(e==null || parent.distTo(e)>followdist){
            boolean b = rand.nextBoolean();
            int d = rand.nextInt(3);
            if(b){
                switch (d){
                    case 0:
                        dir[1]--;
                        break;
                    case 1:
                        dir[0]++;
                        break;
                    case 2:
                        dir[0]--;
                        break;
                    case 3:
                        dir[1]++;
                        break;
                    default:
                        break;
                }
            }
        }else{
            if(x<e.getX())dir[0]++;
            if(x>e.getX())dir[0]--;
            if(y<e.getY())dir[1]--;
            if(y>e.getY())dir[1]++;
        }
        return dir;
    }
}
