/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author bokia5200
 */
public class Challenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create a city
        City bootstown = new City();

        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 1, 3, Direction.SOUTH);

        // place road
        for (int i = 0; i <= 10; i = i + 1) {
            new Wall(bootstown, i, 1, Direction.WEST);
        }
        for (int i = 0; i <= 10; i = i + 1) {
            new Wall(bootstown, i, 2, Direction.EAST);
        }
    }
}
