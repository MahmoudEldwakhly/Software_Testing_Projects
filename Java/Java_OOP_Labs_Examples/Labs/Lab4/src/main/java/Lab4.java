/*
 ============================================================================
 Name        : Lab4
 Copyright   : Edges For Training
 Description : This program defines a Car class with constructor,
               setter methods, getter methods, and a method to simulate driving. 
               It demonstrates encapsulation with setters and getters.
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

    // Setters
    public void setBrand(String b) {
        brand = b;
    }

    public void setColor(String c) {
        color = c;
    }

    public void setModel(int m) {
        model = m;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getModel() {
        return model;
    }

    // Method to simulate driving the car
    public void drive() {
        System.out.println("The " + color + " " + brand + " Model " + model + " is driving");
    }
}

// Main class
public class Lab4 {
    public static void main(String[] args) {
        // Creating a Car object using the constructor
        Car C1 = new Car("Toyota", "Red", 2025);

        // Using setters to modify values
        C1.setBrand("Honda");
        C1.setColor("Blue");
        C1.setModel(2023);

        // Using getters to display updated values
        System.out.println("Brand: " + C1.getBrand());
        System.out.println("Color: " + C1.getColor());
        System.out.println("Model: " + C1.getModel());

        // Calling the drive method
        C1.drive();
    }
}
