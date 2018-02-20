/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author bokia5200
 */
public class A2Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a city
        City bootstown = new City();
        
        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 0, 0, Direction.EAST);
        
        // create castle towers
        new Wall(bootstown, 1, 1, Direction.EAST);
        new Wall(bootstown, 1, 1, Direction.NORTH);
        new Wall(bootstown, 1, 1, Direction.WEST);
        new Wall(bootstown, 1, 1, Direction.SOUTH);
        new Wall(bootstown, 1, 4, Direction.SOUTH);
        new Wall(bootstown, 1, 4, Direction.NORTH);
        new Wall(bootstown, 1, 4, Direction.EAST);
        new Wall(bootstown, 1, 4, Direction.WEST);
        new Wall(bootstown, 4, 1, Direction.WEST);
        new Wall(bootstown, 4, 1, Direction.NORTH);
        new Wall(bootstown, 4, 1, Direction.EAST);
        new Wall(bootstown, 4, 1, Direction.SOUTH);
        new Wall(bootstown, 4, 4, Direction.SOUTH);
        new Wall(bootstown, 4, 4, Direction.NORTH);
        new Wall(bootstown, 4, 4, Direction.EAST);
        new Wall(bootstown, 4, 4, Direction.WEST);
        
        // make castle walls
        new Wall(bootstown, 2, 2, Direction.NORTH);
        new Wall(bootstown, 2, 2, Direction.WEST);
        new Wall(bootstown, 2, 3, Direction.NORTH);
        new Wall(bootstown, 2, 3, Direction.EAST);
        new Wall(bootstown, 3, 3, Direction.EAST);
        new Wall(bootstown, 3, 3, Direction.SOUTH);
        new Wall(bootstown, 3, 2, Direction.SOUTH);
        new Wall(bootstown, 3, 2, Direction.WEST);
        
        // make monogram patrol around castle walls
        while(true){
            monogram.move(2);
            monogram.turnRight();
            monogram.move();
            monogram.turnLeft();
            monogram.move();
            monogram.turnLeft();
            monogram.move();
            monogram.turnRight();
            monogram.move(2);
            monogram.turnRight();
        }
    

         
        }
            
    }

