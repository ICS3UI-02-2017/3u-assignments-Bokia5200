/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizzes;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author bokia5200
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create a city
        City bootstown = new City();

        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 4, 0, Direction.EAST);

        // make the staircase
        new Wall(bootstown, 4, 2, Direction.WEST);
        new Wall(bootstown, 4, 2, Direction.NORTH);
        new Wall(bootstown, 3, 3, Direction.WEST);
        new Wall(bootstown, 3, 3, Direction.NORTH);
        new Wall(bootstown, 2, 4, Direction.WEST);
        new Wall(bootstown, 2, 4, Direction.NORTH);
        new Wall(bootstown, 2, 5, Direction.NORTH);
        new Wall(bootstown, 2, 5, Direction.EAST);
        new Wall(bootstown, 3, 6, Direction.NORTH);
        new Wall(bootstown, 3, 6, Direction.EAST);
        new Wall(bootstown, 4, 7, Direction.NORTH);
        new Wall(bootstown, 4, 7, Direction.EAST);

        // place the lights on the staircase
        new Thing(bootstown, 4, 1);
        new Thing(bootstown, 3, 2);
        new Thing(bootstown, 2, 3);
        new Thing(bootstown, 1, 4);

        // make monogram pick up the lights from the wrong side of the staircase
        monogram.move();
        monogram.pickThing();
        monogram.turnLeft();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.pickThing();
        monogram.turnLeft();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.pickThing();
        monogram.turnLeft();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.pickThing();
        
        // make monogram put the lights on the correct side of the staircase
        monogram.move();
        monogram.putThing();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.putThing();
        monogram.turnLeft();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.putThing();
        monogram.turnLeft();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        monogram.putThing();
        monogram.turnLeft();
        monogram.move();
    }
}
