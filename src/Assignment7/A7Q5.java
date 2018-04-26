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
public class A7Q5 {

    public static void chaotic(int rows) {
        
        // Create an empty string for the number of rows that the user wants
        for (int i = 0; i < rows; i++) {
            String asts = "";
            int randNum = (int) (Math.random() * (5 - 1 + 1)) + 1;
            // Take the random number created above and put that many asterisks into the empty string
            for (int j = 0; j < randNum; j++) {
                asts = asts + "*";
            }
            // Output the asterisks to the user
            System.out.println(asts);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask the user how many rows of asterisks they want
        System.out.println("How many rows of asterisks do you want? ");
        chaotic(input.nextInt());
    }
}
