/*
 ============================================================================
 Name        : Q18
 Copyright   : Edges For Training
 Description : This program creates an integer array to store the squares 
               of numbers from 1 to 10 and prints each value with its index.
 ============================================================================
 */

public class Q18 {
    public static void main(String[] args) {
        // Create an array to hold the squares of numbers 1 to 10
        int[] squares = new int[10];

        // Loop through the array and calculate squares
        for (int i = 0; i < squares.length; i++) {
            // Calculate the square of (i + 1)
            squares[i] = (i + 1) * (i + 1);

            // Print the square of the number
            System.out.println("Square of " + (i + 1) + " = " + squares[i]);
        }
    }
}
