/*
 ============================================================================
 Name        : Lab14
 Copyright   : Edges For Training
 Description : This program defines arrays for student names and marks, 
               and calls a function to print the names with their corresponding 
               marks.
 ============================================================================
 */

public class Lab14 {

    public static void main(String[] args) {
        // Define arrays for student names and marks
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Ethan"};
        int[] marks = {85, 92, 78, 88, 90};

        // Call the function to print concatenated results of names and marks
        printStudentResults(names, marks);
    }

    // Function to print student names and their corresponding marks
    public static void printStudentResults(String[] names, int[] marks) {
        System.out.println("Student Results:");
        System.out.println("----------------");

        // Iterate through the arrays and print each student's name and marks
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }
}
