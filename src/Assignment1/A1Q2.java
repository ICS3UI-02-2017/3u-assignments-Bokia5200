/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author bokia5200
 */
public class A1Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // create a city for the robot
        City bootstown = new City();
        
        // put a robot in Bootstown
        RobotSE monogram = new RobotSE(bootstown, 1, 2, Direction.SOUTH);
        
        // create seven walls
        new Wall(bootstown, 1, 1, Direction.NORTH);
        new Wall(bootstown, 1, 1, Direction.WEST);
        new Wall(bootstown, 2, 1, Direction.WEST);
        new Wall(bootstown, 2, 1, Direction.SOUTH);
        new Wall(bootstown, 1, 2, Direction.SOUTH);
        new Wall(bootstown, 1, 2, Direction.NORTH);
        new Wall(bootstown, 1, 2, Direction.EAST);
        
        
        // create a newspaper
        new Thing(bootstown, 2, 2);
        
        // move monogram to outside of his house
        monogram.turnRight();
        monogram.move();
        monogram.turnLeft();
        monogram.move();
        monogram.turnLeft();
        monogram.move();
        
        // make monogram pick up the newspaper
        monogram.pickThing();
        
        // move monogram back inside his house, to his "bed"
        monogram.turnAround();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.turnRight();
    }
}
