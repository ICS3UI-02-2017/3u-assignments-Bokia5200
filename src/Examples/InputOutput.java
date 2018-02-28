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
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // print a line of text
        System.out.println("Hello World");
        System.out.println("Another line!");
        System.out.println("Another one!");

        // print a blank line
        System.out.println();

        // printing on the same line
        System.out.print("I like ");
        System.out.println("cake!");

        // special characters using \
        // (escape characters)
        // quotation marks
        System.out.println("\"I'm inside quotation marks\"");

        // slash \\
        System.out.println("A slash\\");
        // tab
        System.out.println("pop\tpizza\tfries");

        // a new line \n
        System.out.println("One line\nSecond line");

        // make an integer storing 10
        int number = 10;
        System.out.println("number = " + number);
        System.out.println("number = " + number + ". YAY!");

        //use a Scanner to read info
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name.");
        // make a string to store a name
        String name = input.nextLine();

        // say hello
        System.out.println("Hello " + name);
        
        // ask what year they were born
        System.out.println("What year were you born?");
        
        // make a variable to store the year
        int birthYear = input.nextInt();
        int age = 2018 - birthYear;
        
        // your an idiot loop
        while (age < 0){
            System.out.println("Try again...");
            birthYear = input.nextInt();
            age = 2018 - birthYear;
        }
        // tell the user
        System.out.println("You are " + age + " years old!");
        
        if(age < 0) {
            System.out.println("I don't think so...");
        }else if (age > 30) {
            System.out.println("You are old!");
        }

    }
}
