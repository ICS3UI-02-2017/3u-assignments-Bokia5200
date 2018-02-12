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
 * A1Q1 Assignment 1
 * @author bokia5200
 */
public class A1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create a city for the robot
        City bootstown = new City();
        
        //put a robot in Bootstown
        RobotSE monogram = new RobotSE(bootstown, 0, 2, Direction.WEST);
        
        //create eight walls
        new Wall(bootstown, 1, 1, Direction.WEST);
        new Wall(bootstown, 2, 1, Direction.WEST);
        new Wall(bootstown, 2, 1, Direction.SOUTH);
        new Wall(bootstown, 2, 2, Direction.SOUTH);
        new Wall(bootstown, 2, 2, Direction.EAST);
        new Wall(bootstown, 1, 2, Direction.EAST);
        new Wall(bootstown, 1, 2, Direction.NORTH);
        new Wall(bootstown, 1, 1, Direction.NORTH);
        
        //move robot twice
        monogram.move(2);
        
        //turn monogram to the left
        monogram.turnLeft();
        
        //move robot three times
        monogram.move(3);
        
        //turn monogram to the left
        monogram.turnLeft();
        
        //move robot three times
        monogram.move(3);
        
        //turn monogram to the left
        monogram.turnLeft();
        
        //move robot three times
        monogram.move(3);
        
        //turn monogram to the left
        monogram.turnLeft();
        
        //move robot once
        monogram.move();
    }
}
