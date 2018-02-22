/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author bokia5200
 */
public class ForLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a city
        City bootstown = new City();

        // Create a robot
        RobotSE monogram = new RobotSE(bootstown, 1, 1, Direction.EAST);

        // counted while loop
        int numberOfMoves = 5;
        
        // if there are still moves to do
        while (numberOfMoves > 0) {
            monogram.move();
            numberOfMoves = numberOfMoves - 1;
        }
        monogram.turnAround();
        
        // counting the other way
        numberOfMoves = 0;
        while(numberOfMoves < 5){
            monogram.move();
            numberOfMoves = numberOfMoves + 1;
        }
        monogram.turnAround();
        // use a for loop to move
        for(int count = 0; count < 5; count++){
            monogram.move();
        }
        int x = 10;
        x = x + 5; // adds 5
        x += 5; // adds 5
        
        x -= 10; // subtract 10 shortcut
    }
}
