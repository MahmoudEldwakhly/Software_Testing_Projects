/*
 ============================================================================
 Name        : Q8
 Copyright   : Edges For Training
 Description : This program reads the temperature from the user and classifies it 
               into four categories: "Freezing", "Cold", "Warm", or "Hot" based 
               on the temperature value.
 ============================================================================
 */

import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the temperature
        System.out.print("Enter temperature: ");
        int t = input.nextInt();

        // Check temperature ranges and print the corresponding message
        if (t < 0)
            System.out.println("Freezing");
        else if (t <= 10)
            System.out.println("Cold");
        else if (t <= 25)
            System.out.println("Warm");
        else
            System.out.println("Hot");
    }
}
