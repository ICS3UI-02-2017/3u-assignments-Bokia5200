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
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name:");
        String name = input.nextLine();
        System.out.print("What was the first test out of?:");
        double total1 = input.nextDouble();
        System.out.print("What mark did you get?:");
        double mark1 = input.nextDouble();
        System.out.print("What was the second test out of?:");
        double total2 = input.nextDouble();
        System.out.print("What mark did you get?:");
        double mark2 = input.nextDouble();
        System.out.print("What was the third test out of?:");
        double total3 = input.nextDouble();
        System.out.print("What mark did you get?:");
        double mark3 = input.nextDouble();
        System.out.print("What was the fourth test out of?:");
        double total4 = input.nextDouble();
        System.out.print("What mark did you get?:");
        double mark4 = input.nextDouble();
        System.out.print("What was the fifth test out of?:");
        double total5 = input.nextDouble();
        System.out.print("What mark did you get?:");
        double mark5 = input.nextDouble();

        // Calculate the marks for each test, and the average for all 5 tests

        System.out.println("Test scores for Doug");
        double test1 = mark1 / total1 * 100;
        System.out.println("test1: " + test1 + "%");
        double test2 = mark2 / total2 * 100;
        System.out.println("test2: " + test2 + "%");
        double test3 = mark3 / total3 * 100;
        System.out.println("test3: " + test3 + "%");
        double test4 = mark4 / total4 * 100;
        System.out.println("test4: " + test4 + "%");
        double test5 = mark5 / total5 * 100;
        System.out.println("test5: " + test5 + "%");
        double total = test1 + test2 + test3 + test4 + test5;
        double avg = total/5;
        System.out.println("Average: " + avg + "%");
    }
}
