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
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask the user for the number of students in the class
        System.out.println("How many students are in the class? ");
        int students = input.nextInt();

        // Calculate the sum of all the marks
        int[] results = new int[students];
        double sum = 0;
        System.out.println("Enter the marks: ");
        for (int i = 0; i < results.length; i++) {
            double marks = input.nextDouble();
            sum = sum + marks + results[i];
        }
        // Calculate the average of the test results, and output it to the user
        double avg = sum / students;
        double avgR = Math.round(avg*100)/100.0;
        System.out.println("The class average is: " + avgR + "%");
    }
}

