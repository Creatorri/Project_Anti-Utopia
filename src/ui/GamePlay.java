
package ui;

import assets.LoadArt;
import entity.Entity;
import entity.EntityType;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import render.BlockSpriteSheet;
import render.EntitySpriteSheet;
import world.Level;
import world.TileType;

/**
 *
 * @author Torri
 */
public class GamePlay extends JPanel{
    Level l;
    BufferedImage[] tiletex = new BufferedImage[BlockSpriteSheet.values().length];
    BufferedImage[] rawenttex = new BufferedImage[EntitySpriteSheet.values().length];
    BufferedImage[] enttex = new BufferedImage[EntityType.values().length];
    int offx=0,offy=0;
    public static int x=50,y=50;
    LoadArt la = new LoadArt();
    public GamePlay(){
        final int rows = 4;
        final int cols = 3;
        BufferedImage spriteSheet = la.createBufferedImage("blocks.png");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                tiletex[(i*cols)+j] = spriteSheet.getSubimage(i*64, j*64, 64, 64);
            }
        }
        spriteSheet = la.createBufferedImage("entities.png");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                rawenttex[(i*cols)+j] = spriteSheet.getSubimage(i*64, j*64, 64, 64);
            }
        }
        int c = 0;
        for(int i=0;i<rawenttex.length;i++){
            if(i==6 || i==7 || i==8 || i==10 || i==11) continue;
            enttex[c]=rawenttex[i];
            c++;
        }
        enttex[c] = new BufferedImage(128,128,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = enttex[c].createGraphics();
        g2.drawImage(rawenttex[EntitySpriteSheet.DRAGON1.ordinal()], 0, 0,null);
        g2.drawImage(rawenttex[EntitySpriteSheet.DRAGON2.ordinal()], 0, 64,null);
        g2.drawImage(rawenttex[EntitySpriteSheet.DRAGON3.ordinal()], 64, 0,null);
        g2.drawImage(rawenttex[EntitySpriteSheet.DRAGON4.ordinal()], 64, 64,null);
    }
    public void setReletiveTo(Entity e){
        offx=(getWidth()/2)-e.getX()*64;
        offy=(getHeight()/2)-e.getY()*64;
    }
    public void setReletiveTo(int x, int y){
        offx=(getWidth()/2)-x*64;
        offy=(getHeight()/2)-y*64;
    }
    public void update(){
        if(core.SubTerra.getLevel()==null) return;
        l = core.SubTerra.getLevel();
        for(Entity e: l.ents){
            e.update();
        }
        repaint();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(core.SubTerra.getLevel()==null || core.SubTerra.f==null) return;
        setReletiveTo(x,y);
        setSize(core.SubTerra.f.getSize());
        for(int x1=0;x1<Level.SIZE;x1++){
            for(int y1=0;y1<Level.SIZE;y1++){
                if(x1*64+offx<=-64 || x1*64+offx>=getWidth() || y1*64+offy<=-64 || y1>=getHeight()) continue;
                g2.drawImage(tiletex[TileType.AIR.ordinal()], x1*64+offx,y1*64+offy, this);
                g2.drawImage(tiletex[l.world[x1][y1].ordinal()], x1*64+offx,y1*64+offy, this);
            }
        }
        for(Entity e:l.ents){
            if(e.getX()*e.size+offx<=-e.size || e.getX()*e.size+offx>=getWidth() || e.getY()*e.size+offy<=-e.size || e.getY()>=getHeight()) continue;
            g2.drawImage(enttex[e.t.ordinal()], e.getX()*e.size+offx, e.getY()*e.size+offy, this);
        }
    }
}
