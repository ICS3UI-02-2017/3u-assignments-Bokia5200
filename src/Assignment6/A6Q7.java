/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Arrays;

/**
 *
 * @author bokia5200
 */
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a boolean array, and set all values to true
        boolean[] numbers = new boolean[999];
        for (int x = 0; x < numbers.length; x++) {
            numbers[x] = true;
        }
        // Start at the first prime number, find its multiples and set it to false
        for (int p = 2; p * p <= 999; p++) {
            // If the number is still marked as true, determine whether or not it is prime
            if (numbers[p] == true) {
                for (int y = p * 2; y < 999; y += p) {
                    // Set it to false if it is determined to not be prime
                    numbers[y] = false;
                }
            }
        }
        // Output all the prime numbers that are still marked as true
        for (int i = 2; i < 999; i++){
            if (numbers[i] == true) {
                System.out.print(i + " ");
            }
        }   
    }
}
