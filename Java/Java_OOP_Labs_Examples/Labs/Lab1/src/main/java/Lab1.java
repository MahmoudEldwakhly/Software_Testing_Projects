/*
 ============================================================================
 Name        : Lab1
 Copyright   : Edges For Training
 Description : This program defines a Car class with attributes and a method 
               to simulate driving, then creates a Car object and uses it.
 ============================================================================
 */

// Class definition for Car
class Car {
    // Attributes (fields) of the Car
    String brand;  // The brand of the car (e.g., Toyota, Honda)
    String color;  // The color of the car (e.g., Red, Blue)
    int model;     // The model year of the car (e.g., 2025)

    // Method to simulate driving the car
    void drive() {
        // Print out a message indicating the car is driving
        System.out.println("The " + color + " " + brand + " Model " + model + " is driving");
    }
}

// Main class containing the entry point of the program
public class Lab1 {
    public static void main(String[] args) {
        
        // Creating an object (instance) of Car
        Car C1 = new Car();
        
        // Assigning values to the object's attributes
        C1.brand = "Toyota";
        C1.color = "Red";
        C1.model = 2025;
        
        // Calling the drive method to simulate car movement
        C1.drive();
    }
}
