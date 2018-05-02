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
public class A7Q8 {

    public static boolean allDigitsOdd (int n) {
        // Set the initial number to true
        boolean number = true;
        // While the number is greater than 10 or lesser than -10, see if it can be divided by two evenly, otherwise divide by ten
        while(n >= 10 || n <= -10){
            if (n % 2 == 0) {
                number = false;
            }
            n /= 10;
        }
        return number;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        // Ask the user to input a number
        System.out.print("Enter a number: ");
        boolean oddOrEven = allDigitsOdd(input.nextInt());
        // Tell the user whether all the digits in their number are odd
        System.out.println("All the digits in your number are odd: " + oddOrEven);
    }
}
