package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
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
public class SmileyFace extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "Animated Epic Face";
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // YOUR GAME VARIABLES WOULD GO HERE
    
    Color brown = new Color(68, 44, 9);
    Color mouth = new Color(107, 1, 71);
    Color tongue = new Color(255, 155, 225);
    
    // Variables for left eye movement
    int leftEye = 260;
    
    // How much to translate the eyes each time
    int eyeMovement = +1;
    
    // Variables for right eye movement
    int rightEye = 490;
    
    // Variable for lefteyebrow rotation
    int leftBrow = 0;
    int browMovement = +1;
    
    int rightBrow = 0;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public SmileyFace() {
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

        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        // Create a background
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Create the face
        g.setColor(Color.YELLOW);
        g.fillOval(150, 35, 550, 550);
        
        // Create the eyeballs
        g.setColor(Color.black);
        g.fillArc(230, 190, 145, 180, 0, 180);
        g.fillArc(460, 190, 140, 175, 0, 180);
        g.setColor(Color.white);
        g.fillArc(235, 195, 140, 175, 0, 180);
        g.fillArc(465, 195, 140, 175, 0, 180);
        
        // Create the irises
        g.setColor(Color.BLACK);
        g.fillOval(leftEye, 200, 50, 50);
        g.fillOval(rightEye, 200, 50, 50);

        // Create the mouth
        g.setColor(Color.BLACK);
        g.fillArc(265, 282, 320, 230, 180, 180);
        g.setColor(mouth);
        g.fillArc(275, 300, 300, 205, 180, 180);
        
        // Create the tongue
        g.setColor(tongue);
        g.fillArc(450, 425, 100, 100, 25, 180);
        g.setColor(tongue);
        g2d.translate(455, 495);
        g2d.rotate(Math.toRadians(-26));
        g.fillArc(0, -18, 100, 36, 180, 180);
        g2d.rotate(Math.toRadians(26));
        g2d.translate(-455, -495);
        
        // Create eyebrows
        g.setColor(brown);
        g2d.translate(225, 162);
        g2d.rotate(Math.toRadians(-leftBrow));
        g.fillRoundRect(0, -12, 150, 25, 10, 10);
        g2d.rotate(Math.toRadians(leftBrow));
        g2d.translate(-225, -162);
        
        g2d.translate(460, 162);
        g2d.rotate(Math.toRadians(-rightBrow));
        g.fillRoundRect(0, -12, 150, 25, 10, 10);
        g2d.rotate(Math.toRadians(rightBrow));
        g2d.translate(-460, -162);
        
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
        // Movements for the left and right eye
        leftEye = leftEye + eyeMovement;
        
        if(leftEye > 300){
            eyeMovement = -1;
        }
        if(leftEye < 260){
            eyeMovement = 1;
        }
        rightEye = rightEye + eyeMovement;
        
        // Movements for the left eyebrow
        leftBrow = leftBrow + browMovement;
        
        if (leftBrow > 26){
            browMovement = -1;
        }
        if (leftBrow < 0){
            browMovement = 1;
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
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
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
        SmileyFace game = new SmileyFace();
    }
}
