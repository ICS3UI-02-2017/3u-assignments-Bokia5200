/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bokia5200
 */
public class A6Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask the user how many marks they want to input
        System.out.println("How many marks do you want to enter?: ");
        int numberM = input.nextInt();
        System.out.println("Enter the " + numberM + " mark(s):");

        // Create the array for the numbers to be inputted into
        int[] marks = new int[numberM];
        // Input the numbers into the array
        for (int i = 0; i < marks.length; i++) {
            int numbers = input.nextInt();
            marks[i] = numbers;
        }
        // Go through all the numbers and sort them into ascending order
        for (int i = 0; i < marks.length - 1; i++) {
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[i] > marks[j]) {
                    int numT = marks[i];
                    marks[i] = marks[j];
                    marks[j] = numT;
                }
            }
        }
        // Output the marks to the user
        System.out.println("The marks in ascending order are: " + Arrays.toString(marks));

        if (numberM % 2 == 1) {
            double oddM = numberM/2;
            double Odd = marks[(int) oddM];
            System.out.println("The median is: " + Odd);
        } else{
            double evenM = numberM/2 + 0.5;
            System.out.println(evenM);
            double num1 = Math.ceil(evenM);
            double num2 = Math.floor(evenM);
            System.out.println(num1);
            System.out.println(num2);
            double Even1 = marks[(int)num1];
            double Even2 = marks[(int)num2];
            double totalMed = Even1 + Even2;
            double avgMed = totalMed/2;
            System.out.println("The median is: " + avgMed);
        }
            
        
    }
}
