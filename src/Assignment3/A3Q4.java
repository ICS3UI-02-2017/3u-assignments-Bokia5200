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
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a city
        City danville = new City();
        
        // Create a robot
        RobotSE monogram = new RobotSE(danville, 3, 3, Direction.SOUTH);
        
        // Place the first square
        new Wall(danville, 1, 1, Direction.NORTH);
        new Wall(danville, 1, 1, Direction.WEST);
        new Wall(danville, 1, 2, Direction.NORTH);
        new Wall(danville, 1, 2, Direction.EAST);
        new Wall(danville, 2, 2, Direction.EAST);
        new Wall(danville, 2, 2, Direction.SOUTH);
        new Wall(danville, 2, 1, Direction.SOUTH);
        new Wall(danville, 2, 1, Direction.WEST);
        
        // Place second square
        new Wall(danville, 1, 4, Direction.NORTH);
        new Wall(danville, 1, 4, Direction.WEST);
        new Wall(danville, 2, 4, Direction.WEST);
        new Wall(danville, 2, 4, Direction.SOUTH);
        new Wall(danville, 2, 5, Direction.SOUTH);
        new Wall(danville, 2, 5, Direction.EAST);
        new Wall(danville, 1, 5, Direction.EAST);
        new Wall(danville, 1, 5, Direction.NORTH);
        
        // Place third square
        new Wall(danville, 4, 1, Direction.NORTH);
        new Wall(danville, 4, 1, Direction.WEST);
        new Wall(danville, 5, 1, Direction.WEST);
        new Wall(danville, 5, 1, Direction.SOUTH);
        new Wall(danville, 5, 2, Direction.SOUTH);
        new Wall(danville, 5, 2, Direction.EAST);
        new Wall(danville, 4, 2, Direction.EAST);
        new Wall(danville, 4, 2, Direction.NORTH);
        
        // Place fourth square
        new Wall(danville, 4, 4, Direction.NORTH);
        new Wall(danville, 4, 4, Direction.WEST);
        new Wall(danville, 5, 4, Direction.WEST);
        new Wall(danville, 5, 4, Direction.SOUTH);
        new Wall(danville, 5, 5, Direction.SOUTH);
        new Wall(danville, 5, 5, Direction.EAST);
        new Wall(danville, 4, 5, Direction.EAST);
        new Wall(danville, 4, 5, Direction.NORTH);
        
        // Make monogram move around the four squares
        for (int numberOfMoves = 3; numberOfMoves > 0; numberOfMoves--){
            monogram.move(3);
            monogram.turnLeft();
        }
        for (int numberOfMoves = 3; numberOfMoves > 0; numberOfMoves++)
                monogram.move(6);
                monogram.turnLeft();
                monogram.move(3);
                monogram.turnLeft();
                monogram.move(3);
    }
}
