    package MP;
import sun.nio.cs.ext.MacThai;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

    /**
 * Created by Jhessa on 20/10/2016.
 */
public class Ball{ // creates a ball sprite class
    private static int DIAMETER = 15;
    private Game1 game;
    int x = (int) Math.ceil(800/2) - 12 ;
    int y = (int) Math.ceil(500/2) - 10;
    int xSpeed = 2;
    int ySpeed = 2;
    int score1 = 0;
    int score2 = 0;
    Random rand = new Random();

    public Ball(Game1 game) {this.game = game;}

    public void moveBall(){
        if (x + xSpeed < 0) {
            x = (int) Math.ceil(game.getWidth() / 2) - 12;
            y = (int) Math.ceil(game.getHeight() / 2) - 10;
            Sound.FALL.play();
            score1++;
        }
        if (x + xSpeed > game.getWidth() - DIAMETER) {
            x = (int) Math.ceil(game.getWidth() / 2) - 12;
            y = (int) Math.ceil(game.getHeight() / 2) - 5;
            Sound.FALL.play();
            score2++;
        }
        if (y + ySpeed < 0) {
            ySpeed = 2;
        }
        if (y + ySpeed > game.getHeight() - DIAMETER) {
            ySpeed = -2;
        }
        if (game.racquet1.getBounds().intersects(getBounds())) {
            Sound.BALL.play();
            if (x + 8 > game.racquet1.getx() - 10) {
                xSpeed = -2;
            }else {
                xSpeed = 2;

            }
        }

        if (game.racquet2.getBounds().intersects(getBounds())) {
            Sound.BALL.play();
            xSpeed = 2;
        }
        if(score1 == 5 || score2 == 5){
            xSpeed = 0;
            ySpeed= 0;

        }
        x += xSpeed;
        y += ySpeed;

    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }

    public void paint(Graphics2D g){
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor( new Color(255,20,144));

        g.fillOval(x,y,30,30);

    }
    public int getScore(){
            return score1;
    }

    public int getScore2(){
        return score2;
    }
}











