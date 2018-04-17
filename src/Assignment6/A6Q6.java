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
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask the user for the size of a class
        System.out.print("How many students are in the class?: ");
        int size = input.nextInt();
        System.out.println("Enter the marks: ");

        // Create the array for the marks to be inputted into
        int[] marks = new int[size];
        for (int i = 0; i < marks.length; i++) {
            int j = input.nextInt();
            marks[i] = j;
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
        // Calculate the average of the mark
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }
        double avg = sum / 2;
        // Output the lowest and the highest mark
        System.out.println("The lowest mark is: " + marks[0] + ". The highest mark is: " + marks[(int) size - 1] + ". The average is: " + avg);
    }
}
