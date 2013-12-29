package util;

import core.SubTerra;

/**
 * @author Torri
 */
public class GameThread implements Runnable{
    boolean running = true;
    long start = System.currentTimeMillis();
    long now;
    @Override
    public void run(){
        while(running){
            now = System.currentTimeMillis();
            if((now-start)%20==0){
                tick();
            }
        }
    }
    public void tick(){
        if(SubTerra.getLevel()!=null && SubTerra.f!=null){
            SubTerra.f.gp.update();
        }
    }
}