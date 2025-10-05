/*
 ============================================================================
 Name        : Lab6
 Copyright   : Edges For Training
 Description : This program uses a switch statement to print the day of the week 
               based on the day number (1 to 5). If the number is invalid, 
               it prints an error message.
 ============================================================================
 */

public class Lab6 {
    public static void main(String[] args) {
        // Declare and initialize the day variable
        int day = 3;

        // Use a switch statement to determine the day of the week
        switch (day) {
            case 1:
                // If day equals 1, print Sunday
                System.out.println("Sunday");
                break;
            case 2:
                // If day equals 2, print Monday
                System.out.println("Monday");
                break;
            case 3:
                // If day equals 3, print Tuesday
                System.out.println("Tuesday");
                break;
            case 4:
                // If day equals 4, print Wednesday
                System.out.println("Wednesday");
                break;
            case 5:
                // If day equals 5, print Thursday
                System.out.println("Thursday");
                break;
            default:
                // If day does not match any case, print "Invalid day number"
                System.out.println("Invalid day number");
        }
    }
}
