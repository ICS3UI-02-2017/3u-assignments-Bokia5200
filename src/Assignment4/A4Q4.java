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
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // use a scanner to read the info, ask the user for all the expenses, and store each value
        Scanner input = new Scanner(System.in);
        System.out.print("How much does the food for prom cost? :");
        int food = input.nextInt();
        System.out.print("How much does the DJ cost? :");
        int DJ = input.nextInt();
        System.out.print("How much does it cost to rent the hall? :");
        int hall = input.nextInt();
        System.out.print("How much do decorations cost? :");
        int decor = input.nextInt();
        System.out.print("How much does it cost for the staff? :");
        int staff = input.nextInt();
        System.out.print("How much for miscellaneous costs? :");
        int misc = input.nextInt();
        
        // give total cost and amount of tickets needed to break even
        int total = food + DJ + hall + decor + staff + misc;
        double tickets = total / 35;
        Math.ceil(tickets);
        System.out.println("The total cost is $" + total + ". You will need to sell " + tickets + " tickets to break even.");
    }
}
