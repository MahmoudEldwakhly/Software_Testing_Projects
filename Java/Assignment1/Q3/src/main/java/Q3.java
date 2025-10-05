/*
 ============================================================================
 Name        : Q3
 Copyright   : Edges For Training
 Description : This program demonstrates swapping the values of two integers 
               using a temporary variable.
 ============================================================================
 */

public class Q3 {
    public static void main(String[] args) {
        // Initialize two integers
        int a = 5, b = 10;

        // Print original values before swapping
        System.out.println("Before: a = " + a + ", b = " + b);

        // Swap values using a temporary variable
        int temp = a;
        a = b;
        b = temp;

        // Print values after swapping
        System.out.println("After: a = " + a + ", b = " + b);
    }
}
