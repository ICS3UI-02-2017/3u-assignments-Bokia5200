/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author bokia5200
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // create a city for the robot
        City bootstown = new City();
        
        // put two robots in Bootstown
        RobotSE monogram = new RobotSE(bootstown, 0, 0, Direction.SOUTH);
        RobotSE perry = new RobotSE(bootstown, 0, 1, Direction.SOUTH);
        
        // create nine walls
        new Wall(bootstown, 0, 1, Direction.WEST);
        new Wall(bootstown, 1, 1, Direction.WEST);
        new Wall(bootstown, 1, 1, Direction.SOUTH);
        
        // move monogram to his first stop location
        monogram.move(2);
        monogram.turnLeft();
        
        // move perry to his first stop location
        perry.move();
        perry.turnLeft();
        perry.move();
        perry.turnRight();
        perry.move();
        perry.turnRight();
        
        // make monogram & perry arrive at destination
        monogram.move();
        perry.move();
    }
}
