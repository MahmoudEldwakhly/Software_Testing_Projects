/*
 ============================================================================
 Name        : Ex7
 Copyright   : Edges For Training
 Description : This program reads 10 grades from the user, calculates the 
               sum and average of the grades, and then prints the average.
 ============================================================================
 */

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Define an array to store 10 grades
        int[] grades = new int[10];
        int sum = 0;  // Variable to store the sum of grades

        // Read 10 grades from the user and calculate the sum
        System.out.println("Enter 10 grades:");
        for (int i = 0; i < grades.length; i++) {
            // Prompt the user to enter each grade
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = input.nextInt();  // Store the grade in the array
            sum += grades[i];  // Add the grade to the sum
        }

        // Calculate the average of the grades
        double average = (double) sum / grades.length;

        // Print the result (average grade)
        System.out.println("Average grade = " + average);
    }
}
