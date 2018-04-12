/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author bokia5200
 */
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Tell the user to input ten numbers
        System.out.println("Enter ten marks: ");
        // Create an array for the ten numbers to be inputted into
        int[] marks = new int[10];
        for (int i = 0; i < marks.length; i++) {
            int numbers = input.nextInt();
            marks[i] = numbers;
        }
        for (int i = 0; i < marks.length - 1; i++) {
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[i] > marks[j]) {
                    int numT = marks[i];
                    marks[i] = marks[j];
                    marks[j] = numT; 
                }
            }
        }
            System.out.println("The marks in ascending order are: " + Arrays.toString(marks));
    }
}
