/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 *Learning how to use the Robots
 * @author bokia5200
 */
public class RobotExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Create a City for the robot
        City bootstown = new City();
        
        // put a robot in bootstown
        RobotSE monogram = new RobotSE(bootstown, 2, 3, Direction.EAST);
        
        // create a wall
        new Wall(bootstown, 2, 5, Direction.WEST);
        new Wall(bootstown, 2, 5, Direction.EAST);
        
        // create a thing
        new Thing(bootstown, 2, 4);
        new Thing(bootstown, 2, 4);
        new Thing(bootstown, 2, 4);
        new Thing(bootstown, 2, 4);
        new Thing(bootstown, 2, 4);
        new Thing(bootstown, 2, 4);
        
        // move the robot forward 1 space
        monogram.move();
        
        // move the robot n number of spaces
        // monogram.move(2);
        
        // turn the robot to the left
        monogram.turnLeft();
        
        // put the letter M on monogram
        monogram.setLabel("M");
        
        // set the colour of monogram
        monogram.setColor(Color.blue);
        
        // pick up the thing
        monogram.pickThing();
        
        // move monogram once more
        monogram.move();
        
        // put the thing down
        monogram.putThing();
        monogram.move();
        
        // move monogram around
        monogram.turnAround();
        
        // move monogram down twice
        monogram.move(2);
        
        //pick up another thing
        monogram.pickThing();
        monogram.turnAround();
        
        //move monogram twice, and drop the thing
        monogram.move(2);
        monogram.putThing();
    }
}
