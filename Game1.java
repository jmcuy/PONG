package MP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
/**
 * Created by Jhessa on 20/10/2016.
 */
public class Game1 extends JPanel{
    /*
       Pong main class. This class is a JPanel.
       It contains components which is added to a Container JFrame in main.
    */
    Ball ball = new Ball(this);
    Racquet racquet1 = new Racquet(this, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 740, 150);
    Racquet racquet2 = new Racquet(this, KeyEvent.VK_A, KeyEvent.VK_Z, 40,150);

    public Game1(){ // Constructor for GAME1
               addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                racquet1.keyPressed(e); // what action to do when key is pressed in the racquet(class).keypressed(Function)
                racquet2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet1.keyReleased(e);
                racquet2.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    public void move(){ // moves all sprite classes
        ball.moveBall();
        racquet1.move();
        racquet2.move();
    }

    public static void gameStart(JFrame frame,Game1 game) throws InterruptedException{ // shows an option pane at the beg. of the game
        JOptionPane d =  new JOptionPane();
        int opt = d.showConfirmDialog(null, "WOULD YOU LIKE TO LAUNCH PONG?", "START GAME", JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION){
            paintFrame(frame, game);
            Sound.BACK.loop();
        } else if(opt == JOptionPane.NO_OPTION){
            System.exit(ABORT);
        }
    }

    public void paint(Graphics g){ //overrides paint class in parent
        super.paint(g);
        int W = (int) Math.ceil(800 / 2) - 60;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2D);
        racquet1.paint(g2D);
        racquet2.paint(g2D);
        setBackground(Color.pink);
        g.setColor(new Color(253, 238,255));
        Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .4f);
        g2D.setComposite(c);
        g.setFont(new Font("Comic Sans", Font.BOLD, 50));
        g.drawString("PLAYER2",W + 100,455);
        g.drawString("PLAYER1",20,50);
        g.setFont(new Font("Comic Sans", Font.BOLD, 100));
        g.setColor(Color.red);
        g.drawString(Integer.toString(ball.getScore()),W - 55,80);
        g.drawString(Integer.toString(ball.getScore2()),690,455);
        g.setColor(new Color(240,20,130));
        g.fillRect(0,0,5,500);
        g.fillRect(790,0,5,500);
        g.setColor(Color.gray);
        g2D.fill3DRect(400,0,5,500,false);
    }

    public static void paintFrame(JFrame frame, Game1 game) throws InterruptedException{ // designs the frame for the panel
        frame.add(game);
        frame.setTitle("PONG");
        frame.setSize(800,500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(300,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void showDialog(JFrame frame,Game1 g, String s) throws InterruptedException{ // shows GAME OVER Option pane
        int output = JOptionPane.showConfirmDialog(null,s.toUpperCase() + "WOULD YOU LIKE TO TRY AGAIN?", "GAME OVER", JOptionPane.YES_NO_OPTION);
        if(output == JOptionPane.YES_OPTION){
            frame.dispose();
            JFrame newGame = new JFrame();
            Game1 game = new Game1();
            gameStart(newGame,game);
            paintFrame(newGame, game);
            mainFunc(newGame, game);

        } else if( output == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }


    public static void mainFunc(JFrame frame,Game1 game) throws  InterruptedException { // repaints every move of the ball
        int i = 0;
        int j = 0;
        int x = 0;
        while (x == 0) { // wait before Releasing the ball
            Thread.sleep(3000);
            x++;
        }
        while (game.ball.score1 < 5 && game.ball.score2 < 5) {
            game.move();
            game.repaint();
            if (game.ball.score1 > i) {
                i++;
                Thread.sleep(700);
            } else if (game.ball.score2 > j) {
                j++;
                Thread.sleep(700);
            } else {
                Thread.sleep(10);
            }
        }
        Sound.GAMEOVER.play();
        Sound.BACK.stop();
        if (game.ball.score1 == 5) {
            showDialog(frame, game, "PLAYER 1 WINS ");
        } else if (game.ball.score2 == 5) {
            showDialog(frame, game, "PLAYER 2 WINS ");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame();
        Game1 game = new Game1();
        gameStart(frame,game);
        mainFunc(frame,game);
    }

}

