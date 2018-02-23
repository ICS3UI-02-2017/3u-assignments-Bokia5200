/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
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

        // create two robots
        RobotSE monogram = new RobotSE(bootstown, 0, 2, Direction.SOUTH);
        RobotSE perry = new RobotSE(bootstown, 0, 2, Direction.SOUTH);

        // place road
        new Wall(bootstown, 0, 0, Direction.WEST);
        new Wall(bootstown, 1, 0, Direction.WEST);
        new Wall(bootstown, 2, 0, Direction.WEST);
        new Wall(bootstown, 3, 0, Direction.WEST);
        new Wall(bootstown, 4, 0, Direction.WEST);
        new Wall(bootstown, 5, 0, Direction.WEST);
        new Wall(bootstown, 6, 0, Direction.WEST);
        new Wall(bootstown, 7, 0, Direction.WEST);
        new Wall(bootstown, 8, 0, Direction.WEST);
        new Wall(bootstown, 9, 0, Direction.WEST);
        new Wall(bootstown, 9, 1, Direction.EAST);
        new Wall(bootstown, 8, 1, Direction.EAST);
        new Wall(bootstown, 7, 1, Direction.EAST);
        new Wall(bootstown, 6, 1, Direction.EAST);
        new Wall(bootstown, 5, 1, Direction.EAST);
        new Wall(bootstown, 4, 1, Direction.EAST);
        new Wall(bootstown, 3, 1, Direction.EAST);
        new Wall(bootstown, 2, 1, Direction.EAST);
        new Wall(bootstown, 1, 1, Direction.EAST);
        new Wall(bootstown, 0, 1, Direction.EAST);
        
        // create side of sidewalk
        new Wall(bootstown, 0, 2, Direction.EAST);
        new Wall(bootstown, 3, 2, Direction.EAST);
        new Wall(bootstown, 5, 2, Direction.EAST);
        new Wall(bootstown, 6, 2, Direction.EAST);
        new Wall(bootstown, 9, 2, Direction.EAST);
        new Wall(bootstown, 9, 2, Direction.SOUTH);

        // create first driveway
        new Wall(bootstown, 1, 3, Direction.NORTH);
        new Wall(bootstown, 1, 4, Direction.NORTH);
        new Wall(bootstown, 1, 5, Direction.NORTH);
        new Wall(bootstown, 1, 6, Direction.NORTH);
        new Wall(bootstown, 2, 3, Direction.SOUTH);
        new Wall(bootstown, 2, 4, Direction.SOUTH);
        new Wall(bootstown, 2, 5, Direction.SOUTH);
        new Wall(bootstown, 2, 6, Direction.SOUTH);
        new Wall(bootstown, 1, 6, Direction.EAST);
        new Wall(bootstown, 2, 6, Direction.EAST);
        
        // make second driveway
        new Wall(bootstown, 4, 3, Direction.NORTH);
        new Wall(bootstown, 4, 4, Direction.NORTH);
        new Wall(bootstown, 4, 5, Direction.NORTH);
        new Wall(bootstown, 4, 5, Direction.EAST);
        new Wall(bootstown, 4, 5, Direction.SOUTH);
        new Wall(bootstown, 4, 4, Direction.SOUTH);
        new Wall(bootstown, 4, 3, Direction.SOUTH);
        
        // make third driveway
        new Wall(bootstown, 7, 3, Direction.NORTH);
        new Wall(bootstown, 7, 4, Direction.NORTH);
        new Wall(bootstown, 7, 5, Direction.NORTH);
        new Wall(bootstown, 7, 6, Direction.NORTH);
        new Wall(bootstown, 7, 7, Direction.NORTH);
        new Wall(bootstown, 7, 7, Direction.EAST);
        new Wall(bootstown, 8, 7, Direction.EAST);
        new Wall(bootstown, 8, 7, Direction.SOUTH);
        new Wall(bootstown, 8, 6, Direction.SOUTH);
        new Wall(bootstown, 8, 5, Direction.SOUTH);
        new Wall(bootstown, 8, 4, Direction.SOUTH);
        new Wall(bootstown, 8, 3, Direction.SOUTH);
        
        // place snow on the driveways
        new Thing(bootstown, 1, 2);
        new Thing(bootstown, 1, 3);
        new Thing(bootstown, 1, 4);
        new Thing(bootstown, 1, 5);
        new Thing(bootstown, 2, 2);
        new Thing(bootstown, 2, 4);
        new Thing(bootstown, 2, 6);
        new Thing(bootstown, 4, 2);
        new Thing(bootstown, 4, 3);
        new Thing(bootstown, 4, 4);
        new Thing(bootstown, 7, 2);
        new Thing(bootstown, 7, 3);
        new Thing(bootstown, 7, 7);
        new Thing(bootstown, 8, 3);
        new Thing(bootstown, 8, 4);
        new Thing(bootstown, 8, 6);

        // Make monogram shovel one part of the driveway at a time
        if (!monogram.canPickThing()) {
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
                    monogram.move();
                    monogram.turnLeft();
                    while (monogram.frontIsClear()) {
                        monogram.move();
                        while (monogram.canPickThing()) {
                            monogram.pickThing();
                        }
                    }
                    monogram.turnRight();
                    monogram.move();
                    monogram.turnRight();
                    while (monogram.frontIsClear()) {
                        monogram.move();
                        while (monogram.canPickThing()) {
                            monogram.pickThing();
                        }
                    }
                }
            }
            while (perry.frontIsClear()) {
                perry.move();
                while (perry.canPickThing()) {
                    perry.pickAllThings();
                }
            }
            perry.putAllThings();
        }


    }
}
