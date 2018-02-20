/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author bokia5200
 */
public class A2Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create a city
        City bootstown = new City();

        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 3, 5, Direction.NORTH);
        
        // make the robot orient North regardless of start direction
        if(monogram.getDirection() ==Direction.SOUTH){
          monogram.turnAround();  
        }
        if(monogram.getDirection() ==Direction.EAST) {
            monogram.turnLeft();
        }
        if(monogram.getDirection() == Direction.WEST) {
            monogram.turnRight();
        }

        // make monogram return to origin (0, 0)
        while (monogram.getStreet() > 0) {
            monogram.move(); 
        }
        monogram.turnLeft();
        
        while (monogram.getAvenue() > 0) {
            monogram.move();
        }
        
        
        
        
        }
        
        }
    
    


