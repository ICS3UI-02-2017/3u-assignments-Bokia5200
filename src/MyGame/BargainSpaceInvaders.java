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
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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
    String title = "Bargain Space Invaders";
    
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
    
    // Mouse coordinates
    int mouseX = 0;
    int mouseY = 0;
    
    // Level select screen
    boolean levelSelect = false;
    Font levels = new Font("times new roman", Font.PLAIN, 250);
    boolean one = false;
    boolean two = false;
    boolean three = false;
    boolean four = false;
    boolean five = false;
    
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
    long enemyTimerLastTick = System.currentTimeMillis();
    int enemyDelay = 55;
    
    // For the bullets
    ArrayList<Rectangle> bullets = new ArrayList<>();
    int bulletDelay = 0;
    
    // YOU WON! screen
    boolean youWon = false;
    
    // Game over screen
    boolean gameOver = false;
    boolean restart = false;
    Font biggerFont = new Font("times new roman", Font.BOLD, 124);
    Font timesNewRoman = new Font("times new roman", Font.ITALIC, 36);
    
    // Load in the space enemy image
    BufferedImage enemyImage = loadImage("Space Enemy.png");

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

    public BufferedImage loadImage(String name) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(name));
        } catch (Exception e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        return img;
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
            g.fillRect(350, 450, 300, 50);
            g.setColor(Color.BLACK);
            g.setFont(timesNewRoman);
            g.drawString("PLAY GAME", 405, 485);
        }

        // Draw the level select screen
        if (levelSelect == true) {
            g.setColor(Color.WHITE);
            g.fillRoundRect(100, 100, 200, 250, 40, 40);
            g.fillRoundRect(400, 100, 200, 250, 40, 40);
            g.fillRoundRect(700, 100, 200, 250, 40, 40);
            g.fillRoundRect(250, 400, 200, 250, 40, 40);
            g.fillRoundRect(550, 400, 200, 250, 40, 40);
            g.setFont(levels);
            g.setColor(Color.BLACK);
            g.drawString("1", 135, 300);
            g.drawString("2", 440, 300);
            g.drawString("3", 740, 300);
            g.drawString("4", 290, 600);
            g.drawString("5", 590, 600);
        }

        // Run the level
        if (one == true || two == true || three == true || four == true || five == true) {
            // Make the shooter
            g.setColor(Color.WHITE);
            int[] triangleX = {shooterX1, shooterX2, shooterX3};
            int[] triangleY = {700, 625, 700};
            g.fillPolygon(triangleX, triangleY, 3);

            // Make the enemy ships
            for (int i = 0; i < enemies.size(); i++) {
                Rectangle p = enemies.get(i);
                // g.fillRect(p.x, p.y, p.width, p.height);
                //draw emeny
                g.drawImage(enemyImage, p.x, p.y, p.width, p.height, null);
            }
            // Make the bullets
            for (int i = 0; i < bullets.size(); i++) {
                Rectangle p = bullets.get(i);
                g.fillRect(p.x, p.y, p.width, p.height);
            }
        }
        // Make a YOU WON! screen
        if (youWon == true) {
            g.setColor(Color.WHITE);
            g.setFont(biggerFont);
            g.drawString("YOU WON!", 175, HEIGHT / 2);
            g.setFont(timesNewRoman);
            g.drawString("Press ESCAPE to return to the level select menu", 160, HEIGHT / 2 + 100);
        }
        // Make the game over screen
        if (gameOver == true) {
            g.setColor(Color.WHITE);
            g.setFont(biggerFont);
            g.drawString("GAME OVER", 105, HEIGHT / 2);
            g.setFont(timesNewRoman);
            g.drawString("Press ESCAPE to return to the level select menu", 160, HEIGHT / 2 + 100);
        }
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        // Run the level screen once play game is clicked
        if (levelSelect == true) {
            titleScreen = false;
        }
        // Run the level
        if (one == true || two == true || three == true || four == true || five == true) {
            levelSelect = false;
            levels();
        }
        // Stop running the level if the player loses
        if (gameOver == true) {
            one = false;
            two = false;
            three = false;
            four = false;
            five = false;
        }
        // Stop running the level if the player wins
        if (youWon == true) {
            one = false;
            two = false;
            three = false;
            four = false;
            five = false;
        }
        // If the enemies leave the screen, end the game
        for (int i = 0; i < enemies.size(); i++) {
            Rectangle e = enemies.get(i);
            if (e.y + e.height > HEIGHT) {
                gameOver = true;
            }
        }
    }

    private void levels() {
        bulletDelay += 1;
        // Run all the basic stuff behind each level
        if (one == true || two == true || three == true || four == true || five == true) {
            moveShooter();
            shootBullets();
            moveEnemies();
            checkForCollision();
        }
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
        // Move the shooter back onto the screen if it leaves
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
                e.y += 1;
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
                // Remove the enemies and bullets from the array list if they come in contact
                if (b.intersects(e)) {
                    bullets.remove(b);
                    enemies.remove(e);
                    break;
                }
            }
            // Player wins the level if all enemies are destroyed
            if (enemies.isEmpty()) {
                youWon = true;
            }
        }

        // Collision with enemies and shooter
        for (int x = 0; x < enemies.size(); x++) {
            Rectangle e = enemies.get(x);
            // Trigger game over if the shooter is hit by the enemy
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
            // See which level was clicked
            if (e.getButton() == MouseEvent.BUTTON1) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                // "Play Game" Button
                if (titleScreen == true) {
                    if (mouseX >= 350 && mouseX <= 650 && mouseY >= 450 && mouseY <= 500) {
                        levelSelect = true;
                    }
                }
                if (levelSelect == true) {
                    // for level one
                    if (mouseX >= 100 && mouseX <= 300 && mouseY >= 100 && mouseY <= 350) {
                        one = true;
                    }
                    // for level two
                    if (mouseX >= 400 && mouseX <= 600 && mouseY >= 100 && mouseY <= 350) {
                        two = true;
                    }
                    // for level three
                    if (mouseX >= 700 && mouseX <= 900 && mouseY >= 100 && mouseY <= 350) {
                        three = true;
                    }
                    // for level four
                    if (mouseX >= 250 && mouseX <= 450 && mouseY >= 400 && mouseY <= 650) {
                        four = true;
                    }
                    // for level five
                    if (mouseX >= 550 && mouseX <= 750 && mouseY >= 400 && mouseY <= 650) {
                        five = true;
                    }
                    // Add enemies for level one
                    if (one == true) {
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 100, 50, 50));
                        }
                        // Make the second row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 200, 50, 50));
                        }
                    }
                    // Add enemies for level two
                    if (two == true) {
                        // First row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 0, 50, 50));
                        }
                        // Second row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 100, 50, 50));
                        }
                        // Third row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 200, 50, 50));
                        }
                    }
                    // Add enemies for level three
                    if (three == true) {
                        // First row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, -100, 50, 50));
                        }
                        // Second row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 0, 50, 50));
                        }
                        // Third row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 100, 50, 50));
                        }
                        // Fourth row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 200, 50, 50));
                        }
                    }
                    if (four == true) {
                        // First row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, -200, 50, 50));
                        }
                        // Second row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, -100, 50, 50));
                        }
                        // Third row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 0, 50, 50));
                        }
                        // Fourth row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 100, 50, 50));
                        }
                        // Fifth row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 200, 50, 50));
                        }
                    }
                    if (five == true) {
                        // First row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, -300, 50, 50));
                        }
                        // Second row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, -200, 50, 50));
                        }
                        // Third row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, -100, 50, 50));
                        }
                        // Fourth row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 0, 50, 50));
                        }
                        // Fifth row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 100, 50, 50));
                        }
                        // Sixth row of enemies
                        for (int i = 50; i < 900; i += 105) {
                            enemies.add(new Rectangle(i, 200, 50, 50));
                        }
                    }
                }
            }
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
                if (bulletDelay > 40) {
                    bulletDelay = 0;
                    // Create a new bullet everytime the spacebar is pressed
                    bullets.add(new Rectangle(shooterX2 - 12, 625, 25, 50));
                }
            }
            // To restart
            if (keyCode == KeyEvent.VK_ESCAPE) {
                // Reset the screen and return to the level select screen if the level is lost
                if (gameOver == true) {
                    levelSelect = true;
                    gameOver = false;

                    // Reset the Shooter
                    shooterX1 = 450;
                    shooterX2 = 500;
                    shooterX3 = 550;

                    // Reset the collision detection rectangle behind it
                    shooter.x = 450;

                    // Reset the first row
                    enemies.clear();

                    // Reset the bullets
                    bullets.clear();
                    for (int i = 0; i < bullets.size(); i++) {
                        Rectangle b = bullets.get(i);
                        b.y -= 1;
                    }
                }
                // Return to the level select screen and reset everything if the level is won
                if (youWon == true) {
                    levelSelect = true;
                    youWon = false;

                    // Reset the Shooter
                    shooterX1 = 450;
                    shooterX2 = 500;
                    shooterX3 = 550;

                    // Reset the collision detection rectangle behind it
                    shooter.x = 450;

                    // Reset the first row
                    enemies.clear();
                    
                    // Reset the bullets
                    bullets.clear();
                    for (int i = 0; i < bullets.size(); i++) {
                        Rectangle b = bullets.get(i);
                        b.y -= 1;
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
