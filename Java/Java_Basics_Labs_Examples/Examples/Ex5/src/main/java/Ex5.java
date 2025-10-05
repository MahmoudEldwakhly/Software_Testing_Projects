/*
 ============================================================================
 Name        : Ex5
 Copyright   : Edges For Training
 Description : This program calculates the sum of integers from 1 to 20 
               using a for loop and displays the result.
 ============================================================================
 */

public class Ex5 {

    public static void main(String[] args) {
        // Declare a variable to hold the sum
        int Sum = 0;

        // Use a for loop to iterate through numbers from 1 to 20
        for (int i = 1; i <= 20; i++) {
            // Add each number to the sum
            Sum += i;
        }

        // Print the sum of numbers from 1 to 20
        System.out.println("Sum from 1 to 20 = " + Sum);
    }
}
