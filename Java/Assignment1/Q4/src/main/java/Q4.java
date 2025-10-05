/*
 ============================================================================
 Name        : Q4
 Copyright   : Edges For Training
 Description : This program takes two integers as input from the user and 
               calculates their average. 
 ============================================================================
 */

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter two integers: ");
        int x = input.nextInt();
        int y = input.nextInt();

        // Calculate the average (use 2.0 to ensure floating-point division)
        double average = (x + y) / 2.0;

        // Display the calculated average
        System.out.println("Average = " + average);
    }
}
