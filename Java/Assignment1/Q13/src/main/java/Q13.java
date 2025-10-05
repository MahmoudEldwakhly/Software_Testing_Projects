/*
 ============================================================================
 Name        : Q13
 Copyright   : Edges For Training
 Description : This program prints numbers from 1 to 20, skipping numbers 
               that are divisible by 3 using the 'continue' statement.
 ============================================================================
 */

public class Q13 {
    public static void main(String[] args) {
        // Loop through numbers from 1 to 20
        for (int i = 1; i <= 20; i++) {
            // Skip the current iteration if the number is divisible by 3
            if (i % 3 == 0) continue;
            
            // Print numbers that are not divisible by 3
            System.out.println(i);
        }
    }
}
