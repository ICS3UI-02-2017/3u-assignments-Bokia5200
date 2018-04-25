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
public class A7Q2 {

    public static void examGrade(double m) {
        if (m < 50) {
            System.out.println("Your grade is: F");
        } else {
            if (m >= 50 && m <= 59) {
                System.out.println("Your grade is: D");
            } else {
                if (m >= 60 && m <= 69) {
                    System.out.println("Your grade is: C");
                } else {
                    if (m >= 70 && m <= 79) {
                        System.out.println("Your grade is: B");
                    } else {
                        if (m >= 80) {
                            System.out.println("Your grade is: A");
                        }
                    }
                }
            }
        }





    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask the user for the mark
        System.out.println("What is the test mark? ");
        examGrade(input.nextDouble());

    }
}
