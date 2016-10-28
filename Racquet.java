package MP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.Color.blue;


public class Racquet { // A racquet sprite class

    private Game1 game;
    private int y;
    private int width = 15;
    private int height = 80 ;
    int x;
    int ya = 0;
    private int a;
    private int b;

    public Racquet(Game1 game,int a, int b, int x, int y) { // a Racquet constructor that accepts two key events and a coordinate x and y
        this.game = game;
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (y + ya > 0 && y + ya < game.getHeight() - height) {
            y = y + ya;
        }
    }

    public void paint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(240,130,140));
        g.fill3DRect(x, y, width, height,false);
    }

    public void keyReleased(KeyEvent e) {
        ya = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == a) {
            ya = -3;
        }
        if (e.getKeyCode() == b){
            ya = 3;
        }

    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public int getx(){
        return x;
    }
}