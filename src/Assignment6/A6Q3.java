/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;

/**
 *
 * @author bokia5200
 */
public class A6Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Tell the user to write two numbers
        System.out.println("Enter two integers:  ");

        // Create an array for the numbers to be inputted into
        int[] num = new int[2];
        for (int i = 0; i < num.length; i++) {
            int numbers = input.nextInt();
            num[i] = numbers;
        }
        // If the number is less than the number ahead of it, output it before the other number
        if (num[1] < num[0]) {
            int num1 = num[0];
            num[0] = num[1];
            num[1] = num1;
            System.out.println("The integers in ascending order are: " + num[0] + " " + num[1]);
        } else {
            // If the number is greater than the number ahead of it, output if after the other number
            System.out.println("The integers in ascending order are: " + num[0] + " " + num[1]);
        }
    }
}
