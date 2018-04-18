/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Arrays;

/**
 *
 * @author bokia5200
 */
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create an array and input all the numbers from 2 to 1000
        int[] numbers = new int[999];
        int p = 2;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = p;
            p = p + 1;
        }
        System.out.println(Arrays.toString(numbers));
//        for (int i = 0; i < numbers.length; i++) {
//            boolean isPrime = true;
//            
//            // Check to see if the numbers are prime
//            for (int j = 2; j < i; j++) {
//                if (i%j==0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            // Print the number
//            if (isPrime) {
//                 System.out.println(i);
//            }
//            
//        }
    }
}
