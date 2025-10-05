/*
 ============================================================================
 Name        : Q5
 Copyright   : Edges For Training
 Description : This program takes a full name as input from the user and 
               extracts the first name by splitting the input string.
 ============================================================================
 */

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter their full name
        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();

        // Split the name based on spaces and extract the first name
        String[] parts = fullName.split(" ");
        System.out.println("First Name: " + parts[0]);
    }
}
