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
        
        Scanner input = new Scanner (System.in);
        
        // Tell the user to write two numbers
        System.out.println("Enter two integers:  ");
        
        
        // Sort the numbers in ascending order
        int[] num = new int[2];
        for (int i = 0; i < num.length; i++) {
            int numbers = input.nextInt();
            num [i] = numbers;
        }
        for (int i = 0; i < num.length; i++) {
            if (num [i] < num [i + 1]) {
                System.out.println("The integers in ascending order are: " + num [i] + " " + num [i + 1]);
            } else {
                System.out.println("The integers in ascending order are: " + num [i + 1] + " " + num [i]);
            }
            break;
        }
        
    }
}
