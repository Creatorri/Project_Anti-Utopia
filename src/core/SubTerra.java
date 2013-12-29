
package core;

import ui.Frame;
import world.Level;

/**
 *
 * @author Torri
 */
public class SubTerra {
    public static Frame f;
    private static Level l;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        f = new Frame();
    }
    public static Level setLevel(Level l1){
        l=l1;
        return l;
    }
    public static Level getLevel(){
        return l;
    }
}
