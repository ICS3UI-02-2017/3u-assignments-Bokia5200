/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author bokia5200
 */
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a city for the robot
        City bootstown = new City();
        
        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 1, 2, Direction. EAST);
    }
}
