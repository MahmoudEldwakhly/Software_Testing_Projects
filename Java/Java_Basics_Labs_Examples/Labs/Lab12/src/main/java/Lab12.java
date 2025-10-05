/*
 ============================================================================
 Name        : Lab12
 Copyright   : Edges For Training
 Description : This program uses a for loop to print numbers from 0 to 9, 
               but it skips printing the number 5 using the continue statement.
 ============================================================================
 */

public class Lab12
{
    public static void main(String[] args) 
    { 
        // Use a for loop to iterate over numbers from 0 to 9
        for (int i = 0; i < 10; i++) 
        {
            // If i equals 5, skip the current iteration and continue with the next one
            if (i == 5)
            {
                continue;
            }
            // Print the value of i, excluding 5
            System.out.print(i);
        }
    }
}
