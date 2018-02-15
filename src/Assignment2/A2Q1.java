/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author bokia5200
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a city
        City bootstown = new City();
        
        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 1, 1, Direction.EAST);
        
        // place 10 things
        new Thing(bootstown, 1, 2);
        new Thing(bootstown, 1, 3);
        new Thing(bootstown, 1, 4);
        new Thing(bootstown, 1, 5);
        new Thing(bootstown, 1, 6);
        new Thing(bootstown, 1, 7);
        new Thing(bootstown, 1, 8);
        new Thing(bootstown, 1, 9);
        new Thing(bootstown, 1, 10);
        new Thing(bootstown, 1, 11);
        
        // make the robot pick up 7 things, and move to the end of the row
        while (monogram.countThingsInBackpack() < 7){
            monogram.move();
            monogram.pickThing();
        }
            monogram.move(4);
    }
}
