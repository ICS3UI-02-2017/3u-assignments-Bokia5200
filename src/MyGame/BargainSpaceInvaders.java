package MyGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author bokia5200
 */
public class BargainSpaceInvaders extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    //Title of the window
    String title = "Bargain Space Invaders (WORKING TITLE)";
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // YOUR GAME VARIABLES WOULD GO HERE
    // Controls to move the shooter
    boolean moveLeft = false;
    boolean moveRight = false;
    // Coordinates for the shooter
    int shooterX1 = 450;
    int shooterX2 = 500;
    int shooterX3 = 550;
    // For the enemies
    ArrayList<Point> enemies = new ArrayList<>();
//    double e1 = 100;
    // For the bullets
    ArrayList<Point> bullets = new ArrayList<>();
    int bulletY = 625;
    long enemyTimerLastTick = System.currentTimeMillis();
    int enemyDelay = 25;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public BargainSpaceInvaders() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        preSetup();
        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE

        // Create a background
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Make the shooter
        g.setColor(Color.WHITE);
        int[] triangleX = {shooterX1, shooterX2, shooterX3};
        int[] triangleY = {700, 625, 700};
        g.fillPolygon(triangleX, triangleY, 3);

        // Make the enemy ships
        for (int i = 0; i < enemies.size(); i++) {

            Point p = enemies.get(i);
            g.fillRect(p.x, p.y, 50, 50);
        }

        // Make the shooters
        for (int i = 0; i < bullets.size(); i++) {
            Point p = bullets.get(i);
            g.fillRect(p.x, p.y, 20, 40);
        }



        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        // Make the first row of enemies
        for (int i = 50; i < 900; i += 105) {
            enemies.add(new Point(i, 100));
        }
        // Make the second row of enemies
        for (int i = 50; i< 900; i += 105) {
            enemies.add(new Point(i, 200));
        }

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {



        // Movements for the shooter
        if (moveLeft) {
            shooterX1 -= 3;
            shooterX2 -= 3;
            shooterX3 -= 3;
        } else if (moveRight) {
            shooterX1 += 3;
            shooterX2 += 3;
            shooterX3 += 3;
        }
        if (shooterX1 > WIDTH) {
            shooterX1 = -100;
            shooterX2 = -50;
            shooterX3 = 0;
        }
        if (shooterX3 < 0) {
            shooterX1 = 1000;
            shooterX2 = 1050;
            shooterX3 = 1100;
        }

        // Movements for the bullets
        for (int i = 0; i < bullets.size(); i++) {
            //bullets.add(new Point(100, 100));
            Point p = bullets.get(i);
            p.y -= 0.5;
        }

        // Makes it move slower
        if (System.currentTimeMillis() > enemyTimerLastTick + enemyDelay) {
            // Movements for the enemies
            for (int i = 0; i < enemies.size(); i++) {
                //bullets.add(new Point(100, 100));
                Point p = enemies.get(i);
                p.y += 1;
            }
            enemyTimerLastTick = System.currentTimeMillis();
        }






    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {

            // Get the keycode
            int keyCode = e.getKeyCode();

            // To move the shooter
            if (keyCode == KeyEvent.VK_LEFT) {
                moveLeft = true;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                moveRight = true;
            }

            // To shoot a bullet
            if (keyCode == KeyEvent.VK_SPACE) {
                // Create a new bullet everytime the spacebar is pressed
                bullets.add(new Point(shooterX2, bulletY));
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();

            // To move the shooter
            if (keyCode == KeyEvent.VK_LEFT) {
                moveLeft = false;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                moveRight = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        BargainSpaceInvaders game = new BargainSpaceInvaders();
    }
}
