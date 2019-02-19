package bola;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Bola extends JFrame implements ActionListener{
    JFrame win = new JFrame();
    double x = 50, y = 50, tx = 50, ty = 50;
    double vx = 0, vy = 0;
    
    private Player player;
    private Inimigo bloco1;
    private Inimigo bloco2;
    private Inimigo chao;
    private Lava lava;
    private Lava lava2;
    private Lava lava3;
    JButton botao = new JButton("click!");
    double catX;
    double catY;
    double somaDaMetLarg;
    double somaDaMetAltu;
    double overLapY;
    double overLapX;
    boolean pulo = false;
    
    public void colisao(Player p1, Inimigo p2){
        p1.Mh = p1.tx/2;
        p1.Mv = p1.ty/2;
        p1.centerX = p1.x + p1.Mh;
        p1.centerY = p1.y + p1.Mv;
        p2.Mh = p2.tx/2;
        p2.Mv = p2.ty/2;
        p2.centerX = p2.x + p2.Mh;
        p2.centerY = p2.y + p2.Mv;
        catX = p1.centerX - p2.centerX;
        catY = p1.centerY - p2.centerY;
        somaDaMetLarg = p1.Mh + p2.Mh;
        somaDaMetAltu = p1.Mv + p2.Mv;
        if(Math.abs(catX) < somaDaMetLarg && Math.abs(catY) < somaDaMetAltu){
            overLapX = somaDaMetLarg - Math.abs(catX);
            overLapY = somaDaMetAltu - Math.abs(catY);
            
            if(overLapX >= overLapY){//colisao por cima ou por baixo
                if(catY >= 0){//por cima
                    vy = 0;
                    p1.y += overLapY;
                    
                }else{//por baixo
                    vy = 0;
                    p1.y -= overLapY;
                    pulo = true;
                }
            }else{//colisao pela esquerda ou direita
                if(catX > 0){
                    vx = 0;
                    p1.x += overLapX;
                }else{
                    vx = 0;
                    p1.x -= overLapX;
                }
            }
        }
    }
    
    public void Objetos(){
        player = new Player(Color.green,50,50,50,50);
        bloco1 = new Inimigo(Color.red,200,350,50,50);
        bloco2 = new Inimigo(Color.yellow,300,300,50*3,50);
        lava = new Lava(Color.orange, Color.red, Color.yellow,350,450,50,25);
        lava2 = new Lava(Color.orange, Color.red, Color.yellow,400,450,50,25);
        lava3 = new Lava(Color.orange, Color.red, Color.yellow,450,450,50,25);

        chao = new Inimigo(Color.gray,0,425,350,50);
    }
    public void Janela(){
        ct = new Controles();
        win.addKeyListener(ct);
        win.setSize(500, 500);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Objetos();
        gr = new Graf();
        win.add(gr);
        win.setVisible(true);
        t = new Timer(2, this);
        t.start();
    }
    
    Controles ct;
    Graf gr;
    Timer t;
    
    public void actionPerformed(ActionEvent e) {    
        update();
    }
    
    public void update(){
        lava.anima();
        lava2.anima();
        lava3.anima();
        colisao(player,bloco1);
        colisao(player,bloco2);
        colisao(player,chao);
        player.x += vx;
        player.y += vy;
        vx *= 0.9;
        vy *= 0.9;
        vy += 1.3;
        if(player.x + player.tx > 500){
            vx = 0;
            player.x = 500 - player.tx;
        }
        if(player.x < 0){
            vx = 0;
            player.x = 0;
        }
        if(player.y > 500 - player.ty){
            vy = 0;
            player.y = 15;
            player.x = 55;
        }
        if(player.y < 0){
            vy = 0;
            player.y = 0;
        }
        
        if(ct.esquerda){
            vx -= 0.5;
        }
        if(ct.direita){
            vx += 0.5;
        }
        if(ct.cima && pulo){
            vy -= 28.5;
            pulo = false;
        }
        if(ct.baixo){
            vy += 0.5;
        }
    }
    
    public class Graf extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D line = (Graphics2D) g;
            g.drawString("Cateto X: "+Math.abs(catX), 350, 350);
            g.drawString("Cateto Y: "+Math.abs(catY), 350, 370);
            if(pulo){
            g.drawString("Colidiu em baixo", 350, 390);
            }
            player.paint(g);
            bloco1.paint(g);
            bloco2.paint(g);
            lava.paint(g);
            lava2.paint(g);
            lava3.paint(g);
            chao.paint(g);
            g.setColor(Color.orange);
            line.drawLine((int)player.centerX,(int)player.centerY,(int)bloco1.centerX,(int)bloco1.centerY);
            repaint();
        }
    }
    
    public static void main(String args[]){
        Bola bola = new Bola();
        bola.Janela();
    }
    
}