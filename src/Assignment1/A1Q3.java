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
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a city for the robot
        City bootstown = new City();
        
        // put a robot in Bootstown
        RobotSE monogram = new RobotSE(bootstown, 3, 0, Direction.EAST);
        
        // create nine walls
        new Wall(bootstown, 3, 2, Direction.WEST);
        new Wall(bootstown, 3, 2, Direction.NORTH);
        new Wall(bootstown, 2, 3, Direction.WEST);
        new Wall(bootstown, 1, 3, Direction.WEST);
        new Wall(bootstown, 1, 3, Direction.NORTH);
        new Wall(bootstown, 1, 3, Direction.EAST);
        new Wall(bootstown, 2, 4, Direction.NORTH);
        new Wall(bootstown, 2, 4, Direction.EAST);
        new Wall(bootstown, 3, 4, Direction.EAST);
        
        // create a flag
        new Thing(bootstown, 3, 1);
        
        // make monogram pick up the flag
        monogram.move();
        monogram.pickThing();
        
        // make monogram climb the mountain, and plant the flag at the top
        monogram.turnLeft();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.turnLeft();
        monogram.move(2);
        monogram.turnRight();
        monogram.move();
        monogram.putThing();
        
        // make monogram descend the mountain
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.turnLeft();
        monogram.move();
        monogram.turnRight();
        monogram.move(2);
        monogram.turnLeft();
    }
}
