/*
 ============================================================================
 Name        : Lab10
 Copyright   : Edges For Training
 Description : This program uses a do-while loop to repeatedly prompt the user 
               to enter a number until the user enters 13, at which point it 
               prints a goodbye message and exits.
 ============================================================================
 */

import java.util.Scanner;

public class Lab10 
{
    public static void main(String[] args) 
    {
        // Create a scanner object to take input from the user
        Scanner input = new Scanner(System.in);
        int number;

        // Use a do-while loop to repeatedly prompt for a number
        do {
            System.out.println("Enter a number:");
            number = input.nextInt(); // Read the entered number
            System.out.println("You Entered " + number + ". Enter another number.");

        } while (number != 13); // Continue until the number entered is 13

        // Print a message when the user enters 13 and exit the loop
        System.out.println("You Entered 13 !! Good bye");
    }
}
