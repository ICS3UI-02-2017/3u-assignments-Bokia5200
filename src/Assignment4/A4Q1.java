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
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Use a scanner to read info, and ask user for their name
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter your name:");
        
        // Use a variable to store the name
        String name = input.nextLine();
        
        // Greet the user
        System.out.println("Hello " + name + ". How are you today?");
    }
}
