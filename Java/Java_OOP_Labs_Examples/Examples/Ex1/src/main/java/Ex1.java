/*
 ============================================================================
 Name        : Ex1
 Copyright   : Edges For Training
 Description : This program defines a Circle class with a diameter field,
               a setter to update it, and methods to calculate area and
               perimeter, then demonstrates its usage.
 ============================================================================
 */

// Circle class definition
class Circle {
    // Private member variable for encapsulation
    private double diameter;

    // Setter method to assign diameter
    public void setDiameter(double d) {
        if (d > 0) {
            diameter = d;
        } else {
            System.out.println("Diameter must be positive!");
        }
    }

    // Method to calculate the area of the circle
    public double calculateArea() {
        double radius = diameter / 2;
        return Math.PI * radius * radius;
    }

    // Method to calculate the perimeter (circumference) of the circle
    public double calculatePerimeter() {
        return Math.PI * diameter;
    }
}

// Main class
public class Ex1 {
    public static void main(String[] args) {
        // Create Circle object
        Circle c1 = new Circle();

        // Set the diameter
        c1.setDiameter(14);

        // Calculate and display area and perimeter
        System.out.println("Circle Area: " + c1.calculateArea());
        System.out.println("Circle Perimeter: " + c1.calculatePerimeter());
    }
}
