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
public class A4Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Use a scanner to read the info, and ask user for sum of dice'
        Scanner input = new Scanner(System.in);
        int finalsquare = 1;
        while (finalsquare != 100) {
            System.out.print("Enter sum of dice: ");
            int sum = input.nextInt();
            if (sum < 2 || sum > 12) {
                System.out.println("You Quit!");
                System.exit(sum);
            } else {
                finalsquare = sum + finalsquare;
                
                if (finalsquare == 54) {
                    finalsquare = 19;
                }
                if (finalsquare == 90) {
                    finalsquare = 48;
                }
                if (finalsquare == 99) {
                    finalsquare = 77;
                }
                if (finalsquare == 9) {
                    finalsquare = 34;
                }
                if (finalsquare == 40) {
                    finalsquare = 64;
                }
                if (finalsquare == 67) {
                    finalsquare = 86;
                }
                if (finalsquare > 100) {
                    finalsquare = finalsquare - sum;
                }
                System.out.println("You are now on square " + finalsquare);
                if (finalsquare == 100) {
                    System.out.println("You win!");
                }
            }



        }

    }
}
