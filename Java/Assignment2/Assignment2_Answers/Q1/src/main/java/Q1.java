/*
 ============================================================================
 Name        : Q1
 Copyright   : Edges For Training
 Description : Create a class Student with name and age attributes.
               Initialize them using a constructor and print them.
 ============================================================================
 */

class Student {
    String name;
    int age;

    // Constructor to initialize name and age
    Student(String n, int a) {
        name = n;
        age = a;
    }

    // Method to print student information
    void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Q1 {
    public static void main(String[] args) {
        // Create a Student object and print its details
        Student s1 = new Student("Ahmed", 20);
        s1.printInfo();
    }
}
