package bola;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Player {
    double x,tx,y,ty;
    double metadeL = x/2;
    double metadeA = y/2;

    double Mh,Mv,centerX,centerY;
    Color cor;   
    public Player(Color cor, double x, double y, double tx, double ty){
        this.x = x;
        this.y = y;
        this.tx = tx;
        this.ty = ty;
        this.cor = cor;
        this.centerX = x + metadeL;
        this.centerY = y + metadeA;
    }
    public void paint(Graphics g){
        Graphics2D p = (Graphics2D) g;
        p.setColor(cor);
        p.fill(new Rectangle2D.Double(x,y,tx,ty));
    }
}