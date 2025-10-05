/*
 ============================================================================
 Name        : Lab5
 Copyright   : Edges For Training
 Description : This program defines a Student class that automatically 
               assigns IDs to students using a static variable. 
               It demonstrates how static variables are shared 
               across all instances of a class.
 ============================================================================
 */

class Student {
    // Private attributes (encapsulation)
    private String name;
    private int id;

    // Static variable to keep track of the number of students
    private static int noOfStudents = 0;

    // Constructor: assigns name and automatically generates an ID
    Student(String n) {
        name = n;
        noOfStudents++;
        id = noOfStudents;  // Assigns an incremental ID starting from 1
    }

    // Method to print student data
    public void printStudentData() {
        System.out.println(name + "'s Id is " + id);
    }
}

public class Lab5 {
    public static void main(String[] args) {
        // Create Student objects
        Student S1 = new Student("Ahmed");
        Student S2 = new Student("Mohamed");
        Student S3 = new Student("Mahmoud");
        Student S4 = new Student("Sarah");

        // Print data for each student
        S1.printStudentData();
        S2.printStudentData();
        S3.printStudentData();
        S4.printStudentData();
    }
}
