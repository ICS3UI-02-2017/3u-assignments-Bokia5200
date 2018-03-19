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
public class UbbiDubbiExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Repeat the translator
        while (true) {
            // Get the word to translate
            System.out.println("Enter a word to translate: ");
            String origWord = input.nextLine();

            // Sanitize the input
            origWord = origWord.toLowerCase();

            // Does the word start with a vowel?
            if (origWord.startsWith("a") || origWord.startsWith("e") || origWord.startsWith("i") || origWord.startsWith("o") || origWord.startsWith("u")) {

                //Stick ay on the end
                String transWord = origWord + "ay";
                System.out.println(origWord + " in Pig Latin is " + transWord);
            } else {
                // Walk down the word looking for the vowel
                int length = origWord.length();
                // use a for loop to go through the characters
                for (int i = 0; i < length; i++){
                    // Look at the character at position i, is it a vowel?
                    if(origWord.charAt(i) == 'a' || origWord.charAt(i) == 'e' || origWord.charAt(i) == 'i' || origWord.charAt(i) == 'o' || origWord.charAt(i) == 'u'){
                        // i is the position of the vowel
                        String start = origWord.substring(0, i);
                        String end = origWord.substring(i);
                        
                        // Compute translated word
                        String transWord = end + start + "ay";
                        System.out.println(origWord + " in Pig Latin is " + transWord);
                        
                        // Done looking, so stop the for loop
                        break;
                    }
                        
                }
            }
        }
    }
}
