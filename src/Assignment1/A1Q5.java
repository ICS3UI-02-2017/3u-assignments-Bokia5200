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
 * Exploring the adventures of Major Monogram and Perry
 * @author bokia5200
 */
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a city for the robot
        City bootstown = new City();
        
        // put two robots in Bootstown
        RobotSE monogram = new RobotSE(bootstown, 3, 3, Direction.EAST);
        RobotSE perry = new RobotSE(bootstown, 0, 1, Direction.WEST);
        
        // put the letter "M" on Monogram, and the letter "P" on Perry
        monogram.setLabel("M");
        perry.setLabel("P");
        
        // place monogram's dropped items
        new Thing(bootstown, 0, 0);
        new Thing(bootstown, 1, 0);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 2);
        new Thing(bootstown, 2, 2);
        
        // create the walls of monogram's house
        new Wall(bootstown, 3, 3, Direction.SOUTH);
        new Wall(bootstown, 3, 3, Direction.EAST);
        new Wall(bootstown, 2, 3, Direction.WEST);
        new Wall(bootstown, 2, 3, Direction.NORTH);
        new Wall(bootstown, 2, 3, Direction.EAST);
        
        // make perry pick up three of monogram's items
        perry.move();
        perry.pickThing();
        perry.turnLeft();
        perry.move();
        perry.pickThing();
        perry.turnLeft();
        perry.move();
        perry.pickThing();
        
        // make monogram exit his house and pick up two of his dropped items
        monogram.turnAround();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.pickThing();
        monogram.move();
        monogram.pickThing();
        monogram.turnLeft();
    }
}
