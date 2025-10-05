/*
 ============================================================================
 Name        : Q11
 Copyright   : Edges For Training
 Description : This program continuously takes numbers from the user and adds 
               them together until the total sum exceeds 100. 
               Once the sum exceeds 100, it displays the total sum.
 ============================================================================
 */

import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Variable to hold the sum of entered numbers
        int sum = 0;

        // Keep reading numbers until the sum exceeds 100
        while (sum <= 100) {
            System.out.print("Enter number: ");
            sum += input.nextInt();
        }

        // Print the final sum after exceeding 100
        System.out.println("Sum exceeded 100! Total = " + sum);
    }
}
