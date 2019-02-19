package bola;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Inimigo {
    double x,y,tx,ty;
    double metadeL = x/2;
    double metadeA = y/2;
    
    double Mh,Mv,centerX,centerY;
    Color cor;
    
    public Inimigo(Color cor, double x, double y, double tx, double ty){
        this.x = x;
        this.y = y;
        this.tx = tx;
        this.ty = ty;
        this.cor = cor;
    }

    public void paint(Graphics g){
        Graphics2D i = (Graphics2D) g;
        i.setColor(cor);
        i.fill(new Rectangle2D.Double(x,y,tx,ty));
    }
}
