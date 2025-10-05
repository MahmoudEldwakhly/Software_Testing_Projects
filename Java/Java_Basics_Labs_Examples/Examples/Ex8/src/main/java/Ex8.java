/*
 ============================================================================
 Name        : Ex8
 Copyright   : Edges For Training
 Description : This program calculates and prints the average of numbers 
               in an array using a for-each loop.
 ============================================================================
 */

public class Ex8 {
    public static void main(String[] args) {
        // Define an array of numbers
        int[] numbers = {80, 90, 75, 60, 85};  
        int sum = 0;  // Variable to store the sum of numbers

        // Use a for-each loop to iterate through each number in the array
        for (int num : numbers) {
            sum += num;  // Add each number to the sum
        }

        // Calculate the average of the numbers in the array
        double average = (double) sum / numbers.length;

        // Print the average
        System.out.println("Average of the array is: " + average);
    }
}
