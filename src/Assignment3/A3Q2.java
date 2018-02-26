/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

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
        
        
    }
}
