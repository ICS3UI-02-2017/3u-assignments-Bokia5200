/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 *
 * @author bokia5200
 */
public class MethodsExample {

    // The hello world method to say hello
    public static void helloWorld() {
        System.out.println("Hello World!");
    }
    
    // Say hello to a user
    public static void sayHello(String name) {
        System.out.println("Hello " + name);
    }
    
    public static double posQuadFormula(double a, double b, double c) {
        double discrim = b*b - 4*a*c;
        double root = (-b + Math.sqrt(discrim)) / (2*a);
        return root;
    }
    // Calculates the positive root of a quadratic formula
    public static double[] quadFormula(double a, double b, double c) {
        // Create the array to store both roots
        double[] roots = new double [2];
        // Calculate the roots
        double discrim = b*b -4*a*c;
        roots[0] = (-b + Math.sqrt(discrim))/(2*a);
        roots[1] = (-b - Math.sqrt(discrim))/(2*a);
        // Send back the roots
        return roots;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner (System.in);
        // Call the helloWorld method
        helloWorld();
        
        System.out.println("What is your name?");
        String user = in.nextLine();
        sayHello(user);
        
        // Calculate the positive root of 3x^2 + 7x + 1.5
        double pRoot = posQuadFormula(1, -5, -50);
        System.out.println("The positive root is: " + pRoot);
        
        double[] roots = quadFormula(1, -5, -50);
        System.out.println("The roots are: " + roots[0] + " & " + roots[1]);
    }
}
