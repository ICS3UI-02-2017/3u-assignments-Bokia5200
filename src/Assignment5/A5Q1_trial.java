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
public class A5Q1_trial {

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
            origWord = origWord + " ";
            String transWord = "";
            for (int i = 0; i < length; i++) {
                // Build onto the empty string
                if (origWord.charAt(i) == 'a' || origWord.charAt(i) == 'e' || origWord.charAt(i) == 'i' || origWord.charAt(i) == 'o' || origWord.charAt(i) == 'u') {
                    transWord = transWord + "ub" + origWord.charAt(i);
                    // For consecutive vowels, do not change the word
                    if (origWord.charAt(i++) == 'a') {
                        transWord = transWord + origWord.charAt(i);
                        i++;
                    } else {
                        // If the consecutive vowel is not an "a"
                        transWord = transWord + origWord.charAt(i);
                    }
                } else {
                    // Add the letter to the string if it is a consonant
                    transWord = transWord + origWord.charAt(i);
                }
                if (origWord.charAt(i) == 'a' || origWord.charAt(i) == 'e' || origWord.charAt(i) == 'i' || origWord.charAt(i) == 'o' || origWord.charAt(i) == 'u') {
                    transWord = transWord + "ub" + origWord.charAt(i);
                    // For consecutive vowels, do not change the word
                    if (origWord.charAt(i++) == 'e') {
                        transWord = transWord + origWord.charAt(i);
                        i++;
                    } else {
                        // If the consecutive vowel is not an "e"
                        transWord = transWord + origWord.charAt(i);
                    }
                }
                if (origWord.charAt(i) == 'a' || origWord.charAt(i) == 'e' || origWord.charAt(i) == 'i' || origWord.charAt(i) == 'o' || origWord.charAt(i) == 'u') {
                    transWord = transWord + "ub" + origWord.charAt(i);
                    // For consecutive vowels, do not change the word
                    if (origWord.charAt(i++) == 'i') {
                        transWord = transWord + origWord.charAt(i);
                        i++;
                    } else {
                        // If the consecutive vowel is not an "i"
                        transWord = transWord + origWord.charAt(i);
                    }
                }
                if (origWord.charAt(i) == 'a' || origWord.charAt(i) == 'e' || origWord.charAt(i) == 'i' || origWord.charAt(i) == 'o' || origWord.charAt(i) == 'u') {
                    transWord = transWord + "ub" + origWord.charAt(i);
                    // For consecutive vowels, do not change the word
                    if (origWord.charAt(i++) == 'o') {
                        transWord = transWord + origWord.charAt(i);
                        i++;
                    } else {
                        // If the consecutive vowel is not an "o"
                        transWord = transWord + origWord.charAt(i);
                    }
                }
                if (origWord.charAt(i) == 'a' || origWord.charAt(i) == 'e' || origWord.charAt(i) == 'i' || origWord.charAt(i) == 'o' || origWord.charAt(i) == 'u') {
                    transWord = transWord + "ub" + origWord.charAt(i);
                    // For consecutive vowels, do not change the word
                    if (origWord.charAt(i++) == 'u') {
                        transWord = transWord + origWord.charAt(i);
                        i++;
                    } else {
                        // If the consecutive vowel is not an "u"
                        transWord = transWord + origWord.charAt(i);
                    }
                }
            }
            // Tell the user what the translated version of the word is
            System.out.println(origWord + " in Ubbi Dubbi is: " + transWord);
            break;
        }
    }
}