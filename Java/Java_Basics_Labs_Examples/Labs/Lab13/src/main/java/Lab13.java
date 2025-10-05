/*
 ============================================================================
 Name        : Lab13
 Copyright   : Edges For Training
 Description : This program defines a method to add two numbers and then 
               calls this method from the main method to display the result.
 ============================================================================
 */

public class Lab13 
{
    // Method to add two integers
    public static int add(int x, int y)
    {
        return x + y;  // Return the sum of x and y
    }

    public static void main(String[] args) 
    {
        // Declare and initialize two integer variables
        int First_number  = 5;
        int Second_number = 10;

        // Call the add method and store the result
        int Result = add(First_number, Second_number);

        // Print the result of the addition
        System.out.println(First_number + " + " + Second_number + " = " + Result);
    }
}
