/*
 ============================================================================
 Name        : Q10
 Copyright   : Edges For Training
 Description : This program takes a number from the user and prints its 
               multiplication table from 1 to 12.
 ============================================================================
 */

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        // Loop through numbers 1 to 12 and print the multiplication table
        for (int i = 1; i <= 12; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}
