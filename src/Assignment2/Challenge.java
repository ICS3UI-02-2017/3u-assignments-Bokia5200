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
        RobotSE monogram = new RobotSE(bootstown, 0, 3, Direction.SOUTH);

        // place road
        for (int i = 0; i <= 10; i = i + 1) {
            new Wall(bootstown, i, 1, Direction.WEST);
        }
        for (int i = 0; i <= 10; i = i + 1) {
            new Wall(bootstown, i, 2, Direction.EAST);
        }
        // create side of sidewalk
        new Wall(bootstown, 0 , 3, Direction.EAST);
                
        // create first driveway
        new Wall(bootstown, 1, 4, Direction.NORTH);
        new Wall(bootstown, 1, 5, Direction.NORTH);
        new Wall(bootstown, 1, 6, Direction.NORTH);
        new Wall(bootstown, 1, 7, Direction.NORTH);
        new Wall(bootstown, 2, 4, Direction.SOUTH);
        new Wall(bootstown, 2, 5, Direction.SOUTH);
        new Wall(bootstown, 2, 6, Direction.SOUTH);
        new Wall(bootstown, 2, 7, Direction.SOUTH);
        new Wall(bootstown, 1, 7, Direction.EAST);
        new Wall(bootstown, 2, 7, Direction.EAST);
        
        // Make monogram shovel one part of the driveway at a time
        if (monogram.canPickThing()) {
            monogram.move();
            monogram.turnLeft();
        }
        while (true) {
            while (monogram.frontIsClear()) {
                monogram.move();
                while (monogram.canPickThing()) {
                    monogram.pickThing();
                }
            }
            monogram.turnAround();
            while (monogram.frontIsClear()) {
                monogram.move();
            }
            monogram.putAllThings();
            monogram.turnLeft();
            monogram.move();
            if (monogram.canPickThing()) {
                monogram.turnLeft();
            } else {
                monogram.move();
                monogram.turnLeft();
                while (!monogram.frontIsClear()) {
                    monogram.turnRight();
                }
            }
        }

    }
}
