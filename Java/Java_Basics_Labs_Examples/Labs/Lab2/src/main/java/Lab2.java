/*
 ============================================================================
 Name        : Lab2
 Copyright   : Edges For Training
 Description : This program prompts the user to enter their diploma name and 
               number, and then displays a welcome message.
 ============================================================================
 */

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter their Diploma Name
        System.out.println("Enter your Diploma Name");
        String Diploma = input.nextLine();
        
        // Prompt the user to enter their Diploma Number
        System.out.println("Enter Your Diploma Number");
        int Diploma_Number = input.nextInt();
        
        // Output a welcome message with the user's diploma name and number
        System.out.println("Welcome to " + Diploma + " " + Diploma_Number);
    }
}
