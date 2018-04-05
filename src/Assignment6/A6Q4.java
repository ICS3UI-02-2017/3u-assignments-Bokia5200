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
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        
        // Tell the user to input ten numbers
        System.out.println("Enter ten marks: ");
        
        // Create an array for the ten numbers to be inputted into
        double[] marks = new double[10];
        for (int i = 0; i < marks.length; i++) {
            double num = input.nextDouble();
            marks [i] = num;
        }
        double n = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks [i] > marks [i++]){
               n = n + marks [i];
                System.out.println("The marks from lowest to highest are: " + n);
            }
            
        }
        
        
    }
}
