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

    public static double compoundInterest(double p, double r, int n) {
        
        // Calculate the compound interest
        double B = p * (Math.pow((1+r), n));
        return B;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Ask for the three values
        System.out.println("What is the principal amount, the interest rate, and the number of years?");
        double p = input.nextDouble();
        double r = input.nextDouble();
        int n = input.nextInt();
        // Output the result to the user
        double B = compoundInterest(p,r,n);
        System.out.println("The balance remaining is: $" + B);
        
    }
}
