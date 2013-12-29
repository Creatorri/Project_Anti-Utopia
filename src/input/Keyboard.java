
package input;

import core.SubTerra;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ui.GamePlay;

/**
 *
 * @author Torri
 */
public class Keyboard implements KeyListener{
    private final boolean[] keys = new boolean[1000];
    private int[] keyn = new int[4];
    public boolean[] keyBind = new boolean[4];
    /**
     * Sets up a keyboard input listener
     * @param keybinds 
     */
    public Keyboard(int[] keybinds){
        keyn=keybinds;
        for(boolean k: keys){
            k=false;
        }
    }
    /**
     * changes settings w/o making new instance
     * @param kb 
     */
    public void checkSettings(String[] kb){
        for(int i=0;i<kb.length;i++){
            keyn[i]=Integer.parseInt(kb[i]);
        }
    }
    /**
     * Receives when key is typed
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if(keyBind[0]){
            GamePlay.y--;
        }
        if(keyBind[1]){
            GamePlay.y++;
        }
        if(keyBind[2]){
            GamePlay.x++;
        }
        if(keyBind[3]){
            GamePlay.x--;
        }
    }
    /**
     * Receives when key is pressed
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        for(int i=0;i<keyBind.length;i++){
            keyBind[i]=keys[keyn[i]];
        }
    }
    /**
     * Receives when key is released
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
        for(int i=0;i<keyBind.length;i++){
            keyBind[i]=keys[keyn[i]];
        }
    }
}
