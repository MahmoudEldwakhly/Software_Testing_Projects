/*
 ============================================================================
 Name        : Lab15
 Copyright   : Edges For Training
 Description : This program defines an array of names and uses a for-each loop 
               to greet each person by printing a message.
 ============================================================================
 */

public class Lab15 {
    public static void main(String[] args) {
        // Define an array of names
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Ethan"};

        // Use a for-each loop to greet each person in the array
        for (String name : names) {
            // Print a greeting for each name
            System.out.println("Hello, " + name + "!");
        }
    }
}
