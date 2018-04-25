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
public class A7Q4 {

    public static double compoundInterest(double principle, double rate, int time) {
        // Calculate the compound interest
        double B = principle * ((1 + rate)* Math.pow(principle, time));
        return B;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         System.out.println("What is the principal amount, the interest rate, and the number of years?");
         double p = input.nextDouble();
         double r = input.nextDouble();
         double n = input.nextDouble();
         
    }
}
