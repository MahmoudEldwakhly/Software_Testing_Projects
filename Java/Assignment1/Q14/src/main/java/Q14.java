/*
 ============================================================================
 Name        : Q14
 Copyright   : Edges For Training
 Description : This program prints numbers from 1 to 50 but stops the loop 
               when it finds a number that is divisible by both 2 and 5 
               (i.e., divisible by 10). It then prints the stopping number 
               and exits the loop.
 ============================================================================
 */

public class Q14 {
    public static void main(String[] args) {
        // Loop through numbers from 1 to 50
        for (int i = 1; i <= 50; i++) {
            // Check if the number is divisible by both 2 and 5
            if (i % 2 == 0 && i % 5 == 0) {
                // Print the stopping number and break out of the loop
                System.out.println("Stopped at: " + i);
                break;
            }
            // Print numbers before reaching the stopping condition
            System.out.println(i);
        }
    }
}
