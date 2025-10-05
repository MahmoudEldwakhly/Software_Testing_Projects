/*
 ============================================================================
 Name        : Lab11
 Copyright   : Edges For Training
 Description : This program uses a for loop to print numbers from 0 to 9, 
               but it breaks the loop when the number 5 is encountered.
 ============================================================================
 */

public class Lab11 
{
    public static void main(String[] args) 
    { 
        // Use a for loop to iterate over numbers from 0 to 9
        for (int i = 0; i < 10; i++) 
        {
            // If i equals 5, break out of the loop
            if (i == 5)
            {
                break;
            }
            // Print the value of i
            System.out.print(i);
        }
    }
}
