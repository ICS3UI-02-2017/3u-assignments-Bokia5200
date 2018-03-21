/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import java.util.Scanner;

/**
 *
 * @author bokia5200
 */
public class A5Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Repeat the translator
        while (true) {
            // Ask the user for a word to translate
            System.out.println("Enter a word to translate: ");
            String origWord = input.nextLine();

            // Sanitize the input
            origWord = origWord.toLowerCase();

            // Use a for loop to go through each character, looking for a vowel
            int length = origWord.length();
            String transWord = "";
            for (int i = 0; i < length; i++) {
                    // Compute translated word
                    for (i = 0; i < length; i++) {
                        
                        if (origWord.charAt(i) == 'a' || origWord.charAt(i) == 'e' || origWord.charAt(i) == 'i' || origWord.charAt(i) == 'o' || origWord.charAt(i) == 'u') {
                            // Compute the translated word with vowels
                            transWord = transWord + "ub" + origWord.charAt(i);
                    }else{
                           transWord = transWord + origWord.charAt(i); 
                        }
                        
                }
            }
            
                System.out.println(origWord + " in Ubbi Dubbi is: " + transWord);
//                
//            }
//            int length = origWord.length();
//            String transWord = "";
//            for (int i = 0; i < length; i++) {
//                int index = origWord.indexOf("a", i);
//                    
//                
//            }
            }
        }
    }
