package Examples;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author bokia5200
 */
public class DrawingExample extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    Color purple = new Color(128, 0, 128);
    
    int mouseX = 0;
    int mouseY = 0;
    
    // Game controls
    boolean moveUp = false;
    boolean moveDown = false;
    
    int pacmanY = 400;
    
    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public DrawingExample(){
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
        
        gameTimer = new Timer(desiredTime,this);
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
        // Use our custom colour variable
        g.setColor(purple);
        // Create a background
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // Set the colour
        g.setColor(Color.ORANGE);
        // Draw a filled in rectangle
        // (x, y, width, height)
        g.fillRect(100, 75, 150, 50);
        
        // Draw anything that is an "oval"
        // (x, y, width, height)
        g.setColor(Color.RED);
        g.fillOval(100, 75, 150, 50);
        g.fillOval(100, 125, 150, 50);
        
        // Draw a black outline around the oval
        g.setColor(Color.BLACK);
        g.drawOval(100, 75, 150, 50);
        
        // rounds the corners
        // (x, y, width, height, radiusWidth, radiusHeight)
        g.fillRoundRect(300, 75, 150, 50, 20, 20);
        
        // Draw a polygon
        int[] triangleX = {mouseX, 600, 450};
        int[] triangleY = {mouseY, 500, 500};
        //(Array of X points, Array of Y points, # of points)
        g.fillPolygon(triangleX, triangleY, 3);
        
        // Make Pac-man
        g.setColor(Color.yellow);
        // (x, y, width, height, start angle, amount to rotate)
        g.fillArc(100, pacmanY, 100, 100, 45, 270);
        
        g.setColor(Color.black);
        //(x, y, x, y)
        g.drawLine(250, 125, 500, 400);
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
        
        if (moveUp){
            pacmanY = pacmanY - 3;
        }else if(moveDown){
            pacmanY = pacmanY + 3;
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
            // Set the mouse coordinates
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            // Get the key code
            int keyCode = e.getKeyCode();
            // Which key is being pressed
            if (keyCode == KeyEvent.VK_W){
                moveUp = true;
            }else if (keyCode == KeyEvent.VK_S){
                moveDown = true;
            }

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            // Get the key code
            int keyCode = e.getKeyCode();
            // Which key is being pressed
            if (keyCode == KeyEvent.VK_W){
                moveUp = false;
            }else if (keyCode == KeyEvent.VK_S){
                moveDown = false;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        DrawingExample game = new DrawingExample();
    }
}

