
package ui;

import assets.Audio;
import core.SubTerra;
import input.Keyboard;
import javax.swing.JFrame;
import util.GameLoop;
import world.Level;

/**
 *
 * @author Torri
 */
public class Frame extends JFrame{
    public GamePlay gp = new GamePlay();
    public Keyboard k;
    Audio a = new Audio();
    int[] defkeys = {87,83,68,65};
    public Frame(){
        super("PROJECT ANTI-UTOPIA");
        setSize(750,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setFocusable(true);
        k = new Keyboard(defkeys);
        addKeyListener(k);
        
        gp.setVisible(true);
        SubTerra.setLevel(new Level());
        add(gp);
        gp.update();
        
        GameLoop.start();
        
//        a.playSound("Ingame/Adventum Mirum.wav");
        
        invalidate();
        validate();
        repaint();
    }
}
