/*
 ============================================================================
 Name        : Q12
 Copyright   : Edges For Training
 Description : This program repeatedly prompts the user to enter a password 
               until the correct password "EdgesForTraining" is entered. 
               Once the correct password is entered, it grants access.
 ============================================================================
 */

import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Variable to store the entered password
        String pass;

        // Keep asking the user for the password until it matches "EdgesForTraining"
        do {
            System.out.print("Enter password: ");
            pass = input.next();
        } while (!pass.equals("EdgesForTraining"));

        // Display success message after correct password
        System.out.println("Access Granted!");
    }
}
