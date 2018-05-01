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
public class A7Q7 {

    public static int firstDigit(int n) {
        // Divide the number by 10 until it is less than 10, and then return it
        int first = 0;
        while (n >= 10) {
            n = n / 10;
            first = n;
        }
        while (n <= -10) {
            n = n / 10;
            first = n * -1;
        }
        return first;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Ask the user to enter a number
        System.out.println("Enter a number: ");
        int number = firstDigit(input.nextInt());
        // Return the first digit to the user
        System.out.println("The first number of your digit is: " + number);
    }
}
