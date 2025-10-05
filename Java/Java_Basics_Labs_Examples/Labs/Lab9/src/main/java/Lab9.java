/*
 ============================================================================
 Name        : Lab9
 Copyright   : Edges For Training
 Description : This program prompts the user to enter numbers repeatedly until 
               the number 13 is entered, at which point the program prints a 
               message and ends.
 ============================================================================
 */

import java.util.Scanner;

public class Lab9 {

    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.println("Enter The Number");
        int number = input.nextInt();

        // Continue prompting for numbers until the user enters 13
        while (number != 13) {
            System.out.println("You Entered " + number + " Enter Another number");
            number = input.nextInt();
        }

        // Print a message when the user enters 13 and exit the loop
        System.out.println("You Entered 13 !! Good bye");
    }
}
