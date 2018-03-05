/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;

/**
 *
 * @author bokia5200
 */
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // use a scanner to read the info, and ask the user to input the information
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter the speed limit:");
        int limit = input.nextInt();
        System.out.print("Enter the recorded speed of the car:");
        int speed = input.nextInt();
        
        // give feedback on speed
        if(speed < limit){
            System.out.println("Congratulations, you are within the speed limit");
        }
        if(speed >= limit + 1 && speed <= limit + 20) {
            System.out.println("You are speeding and your fine is $100.");
        }
        if(speed >= limit + 21 && speed <= limit + 30) {
            System.out.println("You are speeding and your fine is $270");
        }
        if (speed >= limit + 31){
            System.out.println("You are speeding and your fine is $500");
        }
    }
}
