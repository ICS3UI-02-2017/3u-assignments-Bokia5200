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
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Use a scanner to read the info, and ask for the measurement.
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the measurement in inches you wish to convert:");
        
        // Use a variable to store the measurement in inches and convert to cm
        double inches = input.nextDouble();
        double cm = 2.54 * inches;
        
        // Give the conversion to the user
        System.out.println(inches + " inches is the same as " + cm + "cm.");
        
        // "Try again" loop
        while (inches < 0) {
            System.out.println("Try again...");
            inches = input.nextDouble();
            cm = 2.54 * inches;
        }
        System.out.println(inches + " inches is the same as " + cm + "cm.");
    }
}
