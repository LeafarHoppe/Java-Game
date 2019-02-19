package bola;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Lava {
    double x,y,tx,ty;
    double metadeL = x/2;
    double metadeA = y/2;
    
    double Mh,Mv,centerX,centerY;
    Color cor;
    Color cor2;
    Color cor3;
    double partX1, partX2, partX3, partX4;
    double partTx1, partTx2, partTx3, partTx4;
    double partTy1, partTy2, partTy3, partTy4;
    double partY1, partY2, partY3, partY4;
    double vx1 = 0.5;
    double vx2 = 0.5;
    double vx3 = 0.5;
    double vx4 = 0.5;
    
    public void anima(){
        partX1+= vx1;
        partX2+= vx2;
        partX3+= vx3;
        partX4+= vx4;
        
        //animação da primeira particula
        if(partX1 + partTx1 >= x + tx -2){
            vx1 *= -1;
        }
        if(partX1 <= x + 2){
            vx1 *= -1;
        }
        //animação da segunda particula
        if(partX2 + partTx2 >= x + tx -2){
            vx2 *= -1;
        }
        if(partX2 <= x + 2){
            vx2 *= -1;
        }
        //animação da terceira particula
        if(partX3 + partTx3 >= x + tx -2){
            vx3 *= -1;
        }
        if(partX3 <= x + 2){
            vx3 *= -1;
        }
        //animação da quarta particula
        if(partX4 + partTx4 >= x + tx -2){
            vx4 *= -1;
        }
        if(partX4 <= x + 2){
            vx4 *= -1;
        }
        
    }
                
    public Lava(Color cor, Color cor2, Color cor3, double x, double y, double tx, double ty){
        this.x = x;
        this.y = y;
        this.tx = tx;
        this.ty = ty;
        this.cor = cor;
        this.cor2 = cor2;
        this.cor3 = cor3;
        partX1 = x + (tx/15); partY1 = y + (ty/4); partTx1 = tx/4; partTy1 = ty/4;
        partX2 = x + (tx/2); partY2 = y + (ty/2); partTx2 = tx/4; partTy2 = ty/4;
        partX3 = x + (tx/15*9); partY3 = y + (ty/6); partTx3 = tx/3; partTy3 = ty/6;
        partX4 = x + (tx/11); partY4 = y + (ty/2*1.3); partTx4 = tx/6; partTy4 = ty/6;
    }

    public void paint(Graphics g){
        Graphics2D i = (Graphics2D) g;
        i.setColor(cor);
        i.fill(new Rectangle2D.Double(x,y,tx,ty));
        i.setColor(cor2);
        i.fill(new Rectangle2D.Double(partX1,partY1,partTx1,partTy1));
        i.fill(new Rectangle2D.Double(partX2,partY2,partTx2,partTy2));
        i.setColor(cor3);
        i.fill(new Rectangle2D.Double(partX3,partY3,partTx3,partTy3));
        i.fill(new Rectangle2D.Double(partX4,partY4,partTx4,partTy4));
    }
}
