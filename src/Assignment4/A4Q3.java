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
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Use a scanner to read the info and ask for the numbers
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter in 4 numbers on separate lines:");

        // Use variables to store the 4 numbers
        String one = input.nextLine();
        String two = input.nextLine();
        String three = input.nextLine();
        String four = input.nextLine();
        
        // Read out the numbers to the user on one line
        System.out.println("Your numbers were " + one + ", " + two + ", " + three + ", " + four + ".");
    }
}
