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
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask the user for the number of people
        System.out.print("How many people's heights are you measuring? ");
        int people = input.nextInt();

        // Calculate the average of the heights using an array
        double[] heights = new double[people];
        double sumH = 0;
        System.out.println("Enter the heights in centimetres: ");
        for (int i = 0; i < heights.length; i++) {
            double h = input.nextDouble();
            heights[i] = h;
            sumH = sumH + heights[i];
        }
        // Calculate the average of the heights
        double avg = sumH / people;

        // Output the above average heights back to the user
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > avg) {
                System.out.println("The heights that are above average are: " + heights [i]);
            }
        }

    }
}
