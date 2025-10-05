/*
 ============================================================================
 Name        : Q16
 Copyright   : Edges For Training
 Description : This program defines a method `maxOfThree` that returns the 
               maximum value among three integers using the built-in Math.max() 
               method. The main method demonstrates its usage with example values.
 ============================================================================
 */

public class Q16 {
    /**
     * Method to find the maximum of three integers
     * @param a First integer
     * @param b Second integer
     * @param c Third integer
     * @return The maximum value among a, b, and c
     */
    public static int maxOfThree(int a, int b, int c) {
        // Use Math.max to compare and find the maximum value
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        // Test the maxOfThree method with example values
        System.out.println(maxOfThree(10, 30, 20)); // 30
    }
}
