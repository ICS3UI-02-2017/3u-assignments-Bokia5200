/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author bokia5200
 */
public class ConditionsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a city for the robot
        City bootstown = new City();
        
        // create a robot
        RobotSE monogram = new RobotSE(bootstown, 2, 1, Direction.EAST);
        
        // create a wall in front
        new Wall(bootstown, 2, 5, Direction.EAST);
        
        // place a few things
        new Thing(bootstown, 2, 2);
        new Thing(bootstown, 2, 4);
        
        // move while the front is clear
        while(monogram.frontIsClear()){
            // if front is clear, do this 
            monogram.move();
            
            // is there something to pick up?
            if(monogram.canPickThing()){
                monogram.pickThing();
            }
        }
        // when front is not clear
        monogram.turnRight();
        
        // do you have 1 thing in your backpack?
        if(monogram.countThingsInBackpack() ==1){
            monogram.move();
        }else if(monogram.countThingsInBackpack() ==2){
            monogram.move(2);
        }else{
            monogram.turnAround();

        }
    }
}
