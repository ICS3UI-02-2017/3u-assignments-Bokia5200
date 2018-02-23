/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author bokia5200
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create a city
        City bootstown = new City();

        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 0, 2, Direction.WEST);

        // create walls
        new Wall(bootstown, 1, 1, Direction.NORTH);
        new Wall(bootstown, 1, 1, Direction.WEST);
        new Wall(bootstown, 1, 2, Direction.NORTH);
        new Wall(bootstown, 1, 2, Direction.EAST);
        new Wall(bootstown, 2, 2, Direction.SOUTH);
        new Wall(bootstown, 2, 1, Direction.WEST);
        new Wall(bootstown, 2, 1, Direction.SOUTH);
        new Wall(bootstown, 2, 2, Direction.EAST);

        // make monogram move around the walls twice
        int numberOfMoves = 2;

        while (numberOfMoves > 0) {
            monogram.move(2);
            monogram.turnLeft();
            monogram.move(3);
            monogram.turnLeft();
            monogram.move(3);
            monogram.turnLeft();
            monogram.move(3);
            monogram.turnLeft();
            monogram.move();

            numberOfMoves = numberOfMoves - 1;
        }

    }
}
