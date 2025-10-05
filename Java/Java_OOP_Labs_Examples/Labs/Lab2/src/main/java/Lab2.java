/*
 ============================================================================
 Name        : Lab2
 Copyright   : Edges For Training
 Description : This program demonstrates encapsulation by using private fields
               and public methods to access and modify data in a Car object.
 ============================================================================
 */

// Class definition for Car
class Car {
    // Private fields (data encapsulation)
    private String brand;
    private String color;
    private int model;

    // Setter methods
    public void setBrand(String b) {
        brand = b;
    }

    public void setColor(String c) {
        color = c;
    }

    public void setModel(int m) {
        model = m;
    }
    
    // Method to simulate driving the car
    public void drive() {
        System.out.println("The " + color + " " + brand + " Model " + model + " is driving");
    }
}

// Main class
public class Lab2 {
    public static void main(String[] args) {
        // Creating a Car object
        Car C1 = new Car();

        // Using setters to assign values
        C1.setBrand("Toyota");
        C1.setColor("Red");
        C1.setModel(2025);

        // Calling the drive method
        C1.drive();
    }
}
