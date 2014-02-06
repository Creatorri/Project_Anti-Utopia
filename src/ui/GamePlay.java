
package ui;

import assets.LoadArt;
import entity.Entity;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import render.Sprite;
import world.Level;
import world.TileType;

/**
 *
 * @author Torri
 */
public class GamePlay extends JPanel{
    Level l;
    int offx=0,offy=0;
    public Sprite[] tiles = new Sprite[TileType.values().length];
    LoadArt la = new LoadArt();
    public GamePlay(){
        for(int i=0;i<tiles.length;i++){
            tiles[i] = new Sprite(TileType.values()[i]);
        }
    }
    public void setReletiveTo(Entity e){
        offx=(getWidth()/2)-e.getX()*64;
        offy=(getHeight()/2)-e.getY()*64;
    }
    public void update(){
        if(core.SubTerra.getLevel()==null) return;
        l = core.SubTerra.getLevel();
        setReletiveTo(l.p);
        for(Entity e: l.ents){
            e.update();
        }
        for(int xx=0;xx<Level.SIZE;xx++){
            for(int yy=0;yy<Level.SIZE;yy++){
                if(l.worldDamage[xx][yy]<0){
                    l.world[xx][yy]=TileType.AIR;
                }
            }
        }
        repaint();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(core.SubTerra.getLevel()==null || core.SubTerra.f==null) return;
        setSize(core.SubTerra.f.getSize());
        for(int x1=0;x1<Level.SIZE;x1++){
            for(int y1=0;y1<Level.SIZE;y1++){
                if(x1*64+offx<=-64 || x1*64+offx>=getWidth() || y1*64+offy<=-64 || y1>=getHeight()) continue;
                g2.drawImage(tiles[l.world[x1][y1].ordinal()].i, x1*64+offx,y1*64+offy, this);
            }
        }
        for(Entity e:l.ents){
            if(e.getX()*64+offx<=-64 || e.getX()*64+offx>=getWidth() || e.getY()*64+offy<=-64 || e.getY()>=getHeight()) continue;
            g2.drawImage(e.sp.i, e.getX()*64+offx, e.getY()*64+offy, this);
        }
        g2.drawImage(l.p.sp.i, l.p.getX()*64+offx, l.p.getY()*64+offy, this);
    }
}
