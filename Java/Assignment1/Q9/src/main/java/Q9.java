/*
 ============================================================================
 Name        : Q9
 Copyright   : Edges For Training
 Description : This program takes a month number (1-12) as input from the user 
               and displays the number of days in that month. February is 
               displayed as "28 or 29 days" considering leap years.
 ============================================================================
 */

import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Prompt user for month number
        System.out.print("Enter month number (1-12): ");
        int month = input.nextInt();

        // Determine and print the number of days in the month
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("31 days");
                break;
            case 4, 6, 9, 11:
                System.out.println("30 days");
                break;
            case 2:
                System.out.println("28 or 29 days (Leap year consideration)");
                break;
            default:
                System.out.println("Invalid month number");
        }
    }
}
