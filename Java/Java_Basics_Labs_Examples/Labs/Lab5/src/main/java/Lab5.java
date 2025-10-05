/*
 ============================================================================
 Name        : Lab5
 Copyright   : Edges For Training
 Description : This program checks the user's percentage and prints whether 
               they are ISTQB certified if their percentage is 65.0 or higher, 
               or informs them they failed and should try again in 1 month.
 ============================================================================
 */

import java.util.Scanner;

public class Lab5 {

    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter their percentage
        System.out.println("Enter your Percentage");
        double Scored_grade = input.nextDouble(); 

        // Check if the scored grade is greater than or equal to 65.0
        if (Scored_grade >= 65.0) {
            // If the condition is true, print that the user is ISTQB certified
            System.out.println("you are ISTQB Certified");
        }
        else {
            // If the condition is false, print that the user failed and needs to try again after 1 month
            System.out.println("You Failed Try Again after 1 month");
        }
    }
}
