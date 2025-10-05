/*
 ============================================================================
 Name        : Q20
 Copyright   : Edges For Training
 Description : This program defines a method `average` that calculates the 
               average of an integer array. It demonstrates the method by 
               computing the average of a sample array of integers.
 ============================================================================
 */

public class Q20 {
    /**
     * Calculates the average of an array of integers
     * @param numbers Array of integers
     * @return The average as a double value
     */
    public static double average(int[] numbers) {
        // Initialize sum
        int sum = 0;

        // Add all numbers in the array
        for (int num : numbers)
            sum += num;

        // Return the average
        return (double) sum / numbers.length;
    }

    public static void main(String[] args) {
        // Sample array of numbers
        int[] nums = {10, 20, 30, 40, 50};

        // Call the average method and print the result
        System.out.println("Average = " + average(nums));
    }
}
