/*
 ============================================================================
 Name        : Q15
 Copyright   : Edges For Training
 Description : This program defines a method `isVowel` that checks if a given 
               character is a vowel (a, e, i, o, u) in either uppercase or 
               lowercase. It then tests the method with example inputs.
 ============================================================================
 */

public class Q15 {
    /**
     * Method to check if a character is a vowel (case-insensitive)
     * @param ch Character to check
     * @return true if the character is a vowel, false otherwise
     */
    public static boolean isVowel(char ch) {
        // Java switch expression to check vowel cases
        return switch (ch) {
            case 'a', 'A', 'o', 'O', 'u', 'U', 'i', 'I', 'e', 'E' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        // Test cases for the isVowel method
        System.out.println(isVowel('a')); // true
        System.out.println(isVowel('z')); // false
    }
}
