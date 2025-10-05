/*
 ============================================================================
 Name        : Lab3
 Copyright   : Edges For Training
 Description : This program defines a Car class with a constructor, 
               setter methods, and a method to simulate driving. 
               It demonstrates object creation and usage.
 ============================================================================
 */

// Class definition for Car
class Car {
    // Private fields (data encapsulation)
    private String brand;
    private String color;
    private int model;

    // Constructor to initialize Car object with given values
    public Car(String b, String c, int m) {
        brand = b;
        color = c;
        model = m;
    }

    // Method to simulate driving the car
    public void drive() {
        System.out.println("The " + color + " " + brand + " Model " + model + " is driving");
    }
}

// Main class
public class Lab3 {
    public static void main(String[] args) {
        // Creating a Car object using the constructor
        Car C1 = new Car("Toyota", "Red", 2025);

        // Calling the drive method
        C1.drive();
    }
}
