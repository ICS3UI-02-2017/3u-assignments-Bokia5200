/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author bokia5200
 */
public class A7Q1 {

    // Calculate the area of the circle with a given radius
    public static double circleArea(double r) {
        double areaC = Math.PI * r * r;
        return areaC;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Ask the user for the radius of the circle
        System.out.println("What is the radius of the circle?");
        double cArea = circleArea(input.nextDouble());
        // Output the area to the user
        System.out.println("The area of the circle is: " + cArea);
    }
}
