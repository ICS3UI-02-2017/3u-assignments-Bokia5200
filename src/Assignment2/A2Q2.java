/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

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
        RobotSE monogram = new RobotSE(bootstown, 1, 2, Direction.EAST);

        // create the floor
        for (int i = 2; i <= 10; i = i + 1) {
            new Wall(bootstown, 1, i, Direction.SOUTH);
        }
        // create hurdles
        new Wall(bootstown, 1, 2, Direction.EAST);
        new Wall(bootstown, 1, 3, Direction.EAST);
        new Wall(bootstown, 1, 5, Direction.EAST);
        new Wall(bootstown, 1, 8, Direction.EAST);

        // create the finish line
        new Thing(bootstown, 1, 10);

        // make monogram complete the race
        while (!monogram.canPickThing()) {
            if (!monogram.isBesideThing(IPredicate.aWall)) {
                monogram.turnRight();
            }

            if (monogram.frontIsClear()) {
                monogram.move();
            } else {
                monogram.turnLeft();
            }
        }



    }
}
