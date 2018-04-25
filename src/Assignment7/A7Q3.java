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
public class A7Q3 {

    public static void factors(int f) {
        
        System.out.println("The factors of " + f + " are:");
        
        // Go through every number starting from 1 up until the number to find its factors
        for (int i = 1; i <= f; i++) {
            if (f % i == 0) {
                System.out.println(i);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Ask the user to find a number to find the factors of
        System.out.println("Enter a number to find factors of: ");
        factors(input.nextInt());
    }
}
