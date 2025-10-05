/*
 ============================================================================
 Name        : Lab7
 Copyright   : Edges For Training
 Description : This program uses the enhanced switch statement (introduced in 
               Java 12) to print the day of the week based on the day number 
               (1 to 5). If the number is invalid, it prints an error message.
 ============================================================================
 */

public class Lab7 {
    public static void main(String[] args) {
        // Declare and initialize the day variable
        int day = 3;

        // Use the enhanced switch statement to determine the day of the week
        switch (day) {
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            default -> System.out.println("Invalid day number");  // If day does not match any case
        }
    }
}
