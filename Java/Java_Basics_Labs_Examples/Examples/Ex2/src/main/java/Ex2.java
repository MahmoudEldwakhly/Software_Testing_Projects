/*
 ============================================================================
 Name        : Ex2
 Copyright   : Edges For Training
 Description : This program prompts the user to enter two numbers and calculates 
               their sum, then displays the result.
 ============================================================================
 */

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        // Declare variables for the first number, second number, and the sum
        int First_number;
        int Second_number;
        int Sum;

        // Create a scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first number
        System.out.println("Enter The First Number");
        First_number = input.nextInt();

        // Prompt the user to enter the second number
        System.out.println("Enter The Second Number");
        Second_number = input.nextInt();
        
        // Adding the 2 integers 
        Sum = First_number + Second_number;
        
        // Printing the output to the user
        System.out.println("Sum Of "+ First_number + " + "+ Second_number + " = " + Sum);
    }
}