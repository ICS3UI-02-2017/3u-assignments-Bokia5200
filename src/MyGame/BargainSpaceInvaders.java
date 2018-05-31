package MyGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
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
    // Title Screen
    boolean titleScreen = true;
    Font titleFont = new Font("times new roman", Font.CENTER_BASELINE, 70);
    Rectangle playGame = new Rectangle(250, 450, 450, 50);
    int mouseX = 0;
    int mouseY = 0;
    // Level select screen
    boolean levelSelect = false;
    boolean one = false;
    // Controls to move the shooter
    boolean moveLeft = false;
    boolean moveRight = false;
    // Coordinates for the shooter
    int shooterX1 = 450;
    int shooterX2 = 500;
    int shooterX3 = 550;
    // For the shooter/enemy collision
    Rectangle shooter = new Rectangle(450, 625, 100, 75);
    // For the enemies
    ArrayList<Rectangle> enemies = new ArrayList<>();
    // For the bullets
    ArrayList<Rectangle> bullets = new ArrayList<>();
    long enemyTimerLastTick = System.currentTimeMillis();
    int enemyDelay = 55;
    // Game over screen
    boolean gameOver = false;
    boolean restart = false;
    Font biggerFont = new Font("times new roman", Font.BOLD, 124);
    Font timesNewRoman = new Font("times new roman", Font.ITALIC, 36);

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
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Start Screen
        if (titleScreen == true) {
            g.setColor(Color.white);
            g.setFont(titleFont);
            g.drawString("BARGAIN SPACE INVADERS", 18, HEIGHT / 2);
            g.setColor(Color.white);
            g.fillRect(playGame.x, playGame.y, playGame.width, playGame.height);
            g.setColor(Color.black);
            g.setFont(timesNewRoman);
            g.drawString("Press 'Enter' to start playing", 270, 485);
        }

        // Run the level
        if (one == true) {
            // Make the shooter
//            g.setColor(Color.yellow);
//            g.fillRect(shooter.x, shooter.y, shooter.width, shooter.height);
            g.setColor(Color.WHITE);
            int[] triangleX = {shooterX1, shooterX2, shooterX3};
            int[] triangleY = {700, 625, 700};
            g.fillPolygon(triangleX, triangleY, 3);

            // Make the enemy ships
            for (int i = 0; i < enemies.size(); i++) {
                Rectangle p = enemies.get(i);
                g.fillRect(p.x, p.y, p.width, p.height);
            }

            // Make the bullets
            for (int i = 0; i < bullets.size(); i++) {
                Rectangle p = bullets.get(i);
                g.fillRect(p.x, p.y, p.width, p.height);
            }
        }
        // Make the game over screen
        if (gameOver == true) {
            g.setColor(Color.WHITE);
            g.setFont(biggerFont);
            g.drawString("GAME OVER", 105, HEIGHT / 2);
            g.setFont(timesNewRoman);
            g.drawString("Press ESCAPE to restart", 300, HEIGHT / 2 + 100);
        }
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        // Make the first row of enemies
        for (int i = 50; i < 900; i += 105) {
            enemies.add(new Rectangle(i, 100, 50, 50));
        }
        // Make the second row of enemies
        for (int i = 50; i < 900; i += 105) {
            enemies.add(new Rectangle(i, 200, 50, 50));
        }
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        if (one == true) {
            titleScreen = false;
            levelOne();
        }
        if (gameOver == true) {
            one = false;
        }

    }

    private void levelOne() {
        moveShooter();
        shootBullets();
        moveEnemies();
        checkForCollision();

    }

    private void moveShooter() {
        // Movements for the shooter
        if (moveLeft) {
            shooterX1 -= 3;
            shooterX2 -= 3;
            shooterX3 -= 3;
            shooter.x -= 3;
        } else if (moveRight) {
            shooterX1 += 3;
            shooterX2 += 3;
            shooterX3 += 3;
            shooter.x += 3;
        }
        if (shooterX1 > WIDTH) {
            shooterX1 = -100;
            shooterX2 = -50;
            shooterX3 = 0;
            shooter.x = -100;
        }
        if (shooterX3 < 0) {
            shooterX1 = 1000;
            shooterX2 = 1050;
            shooterX3 = 1100;
            shooter.x = 1000;
        }
    }

    private void shootBullets() {
        // Movements for the bullets
        for (int i = 0; i < bullets.size(); i++) {
            Rectangle b = bullets.get(i);
            b.y -= 1;
        }
    }

    private void moveEnemies() {
        // Makes it move slower
        if (System.currentTimeMillis() > enemyTimerLastTick + enemyDelay) {
            // Movements for the enemies
            for (int i = 0; i < enemies.size(); i++) {
                Rectangle e = enemies.get(i);
                e.y += 5;
            }
            enemyTimerLastTick = System.currentTimeMillis();
        }
    }

    private void checkForCollision() {
        // Collision with bullets and enemies
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                Rectangle b = bullets.get(i);
                Rectangle e = enemies.get(j);
                if (b.intersects(e)) {
                    b.y = -100;
                    b.x = -100;
                    e.y = -100;
                    e.x = -100;
                }
            }
        }
        // Collision with enemies and shooter
        for (int x = 0; x < enemies.size(); x++) {
            Rectangle e = enemies.get(x);
            if (e.intersects(shooter)) {
                System.out.println("hit");
                shooterX1 = -100;
                shooterX2 = -100;
                shooterX3 = -100;
                gameOver = true;
            }
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

            // Start the level
            if (keyCode == KeyEvent.VK_ENTER) {
                one = true;
            }

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
                bullets.add(new Rectangle(shooterX2 - 12, 625, 25, 50));
            }

            // To restart
            if (keyCode == KeyEvent.VK_ESCAPE) {
                if (gameOver == true) {
                    titleScreen = true;
                    gameOver = false;
                    int shooterX1 = 450;
                    int shooterX2 = 500;
                    int shooterX3 = 550;
                    int[] triangleX = {shooterX1, shooterX2, shooterX3};
                    int[] triangleY = {700, 625, 700};
                    for (int i = 0; i < enemies.size(); i++) {
                        Rectangle p = enemies.get(i);
                        for (int j = 50; j < 900; j += 105){
                            p.x = j;
                            p.y = 100;
                        }
                        
                    }

                    // Make the bullets
                    for (int i = 0; i < bullets.size(); i++) {
                        Rectangle p = bullets.get(i);
                        
                    }
                }

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
