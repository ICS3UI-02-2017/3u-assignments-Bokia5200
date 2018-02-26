/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author bokia5200
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city
        City bootstown = new City();
        
        // Create a robot
        RobotSE monogram = new RobotSE(bootstown, 1, 1, Direction.EAST);
        
        // Turn on counters for the things
        bootstown.showThingCounts(true);
        
        // place 10 things
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        new Thing(bootstown, 1, 1);
        
        // make monogram pick up all the things individually and place them one intersection over
        int numberOfMoves = 10;
        
        while (numberOfMoves > 0) {
            monogram.pickThing();
            monogram.move();
            monogram.putThing();
            monogram.turnAround();
            monogram.move();
            monogram.turnAround();
            
            numberOfMoves = numberOfMoves - 1;
        }
          monogram.move();      
    }
}
