/*
 ============================================================================
 Name        : Q19
 Copyright   : Edges For Training
 Description : This program stores an array of names, prints them in their 
               original order, and then prints them in reverse order.
 ============================================================================
 */

public class Q19 {
    public static void main(String[] args) {
        // Initialize an array of names
        String[] names = {"Ali", "Omar", "Sara", "Lena", "Hana"};

        // Print the original array
        System.out.println("Original array:");
        for (String name : names) {
            System.out.print(name + " ");
        }

        // Reverse the array and print it
        System.out.println("\n\nReversed array:");
        for (int i = names.length - 1; i >= 0; i--) {
            System.out.print(names[i] + " ");
        }
    }
}
