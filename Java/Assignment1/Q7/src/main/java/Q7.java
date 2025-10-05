/*
 ============================================================================
 Name        : Q7
 Copyright   : Edges For Training
 Description : This program takes an integer input from the user and determines 
               whether it is even or odd.
 ============================================================================
 */

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer number
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        // Check if the number is even or odd
        if (num % 2 == 0)
            System.out.println("Even number");
        else
            System.out.println("Odd number");
    }
}
