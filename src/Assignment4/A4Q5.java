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
        int total1 = input.nextInt();
        System.out.print("What mark did you get?:");
        int mark1 = input.nextInt();
        System.out.print("What was the second test out of?:");
        int total2 = input.nextInt();
        System.out.print("What mark did you get?:");
        int mark2 = input.nextInt();
        System.out.print("What was the third test out of?:");
        int total3 = input.nextInt();
        System.out.print("What mark did you get?:");
        int mark3 = input.nextInt();
        System.out.print("What was the fourth test out of?:");
        int total4 = input.nextInt();
        System.out.print("What mark did you get?:");
        int mark4 = input.nextInt();
        System.out.print("What was the fifth test out of?:");
        int total5 = input.nextInt();
        System.out.print("What mark did you get?:");
        int mark5 = input.nextInt();

        // Calculate the marks for each test, and the average for all 5 tests

        System.out.println("Test scores for Doug");
        double test1 = mark1 / total1;
        System.out.println("test1: " + test1 + "%");
        double test2 = mark2 / total2;
        System.out.println("test2: " + test2 + "%");
        double test3 = mark3 / total3;
        System.out.println("test3: " + test3 + "%");
        double test4 = mark4 / total4;
        System.out.println("test4: " + test4 + "%");
        double test5 = mark5 / total5;
        System.out.println("test5: " + test5 + "%");
        double avg = test1 + test2 + test3 + test4 + test5;
        System.out.println("Average: " + avg + "%");

    }
}
