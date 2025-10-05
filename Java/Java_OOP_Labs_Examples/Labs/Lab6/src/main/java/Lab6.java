import java.util.Scanner;
/*
 ============================================================================
 Name        : Lab6
 Copyright   : Edges For Training
 Description : Demonstrates the use of static variables and static methods 
               in a Student class. Each Student has a unique ID, and a 
               static method is used to set the starting ID dynamically.
 ============================================================================
 */

class Student {
    // Private attributes
    private String name;
    private int id;

    // Static variable shared among all students
    private static int currentId;

    // Constructor: assigns name and generates unique ID
    Student(String n) {
        name = n;
        currentId++;     // increment global ID counter
        id = currentId;  // assign unique ID to this student
    }

    // Method to print student data
    public void printStudentData() {
        System.out.println(name + "'s ID is " + id);
    }
    
    // Static method to set the starting ID (before creating students)
    public static void setStartId(int id) {
        currentId = id;
    }
}

public class Lab6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user to enter starting ID value
        System.out.print("Please Enter The Start ID: ");
        int startId = input.nextInt();

        // Set initial starting ID before creating students
        Student.setStartId(startId);

        // Create student objects
        Student S1 = new Student("Ahmed");
        Student S2 = new Student("Mohamed");
        Student S3 = new Student("Sarah");

        // Print data for each student
        S1.printStudentData();
        S2.printStudentData();
        S3.printStudentData();
    }
}
