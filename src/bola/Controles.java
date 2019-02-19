package bola;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener{
    public boolean esquerda = false, direita = false, cima = false, baixo = false;
    Bola bol;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== 37){
            esquerda = true;
        }
        if(e.getKeyCode()== 38){
            cima = true;
        }
        if(e.getKeyCode()== 39){
            direita = true;
        }
        if(e.getKeyCode()== 40){
            baixo = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== 37){
            esquerda = false;
        }
        if(e.getKeyCode()== 38){
            cima = false;
        }
        if(e.getKeyCode()== 39){
            direita = false;
        }
        if(e.getKeyCode()== 40){
            baixo = false;
        }
    }
}
