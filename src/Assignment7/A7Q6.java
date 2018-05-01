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
public class A7Q6 {

    public static int lastDigit (int n) {
        int x = 0;
        for (int i = 0; i < 10; i++) {
            if (n / 10 == i) {
                x = i;   
            }   
        }
        for (int j = 0; j > -10; j--) {
            if (n % -10 == j) {
                x = j * -1;
            }
        }
        return x;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int digit = lastDigit(input.nextInt());
        System.out.println("The last digit of your number is: " + digit);
    }
}
