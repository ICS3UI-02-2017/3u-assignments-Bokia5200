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
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city
        City danville = new City();

        // Create a robot with 20 things
        RobotSE monogram = new RobotSE(danville, 1, 1, Direction.EAST, 20);

        // make monogram sow the field
        int numberOfMoves = 20;

        while (numberOfMoves > 15) {
            monogram.putThing();
            monogram.move();
            numberOfMoves -= 1;
        }
        monogram.turnRight();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        
        while (numberOfMoves > 10) {
            monogram.putThing();
            monogram.move();
            numberOfMoves -= 1;
        }
        monogram.turnLeft();
        monogram.move();
        monogram.turnLeft();
        monogram.move();
        
        while (numberOfMoves > 5) {
            monogram.putThing();
            monogram.move();
            numberOfMoves -= 1;
        }
        monogram.turnRight();
        monogram.move();
        monogram.turnRight();
        monogram.move();
        
        while (numberOfMoves > 0) {
            monogram.putThing();
            monogram.move();
            numberOfMoves -= 1;
        }
        monogram.turnLeft();
        monogram.move();
        monogram.turnLeft();
        monogram.move();
        }
    }

