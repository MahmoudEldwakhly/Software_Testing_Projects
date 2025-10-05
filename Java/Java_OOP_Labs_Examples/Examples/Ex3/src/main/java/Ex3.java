/*
 ============================================================================
 Name        : Ex3
 Copyright   : Edges For Training
 Description : Demonstrates inheritance Base class Shape 
               and derived classes Circle and Triangle.
 ============================================================================
 */

// Base class Shape
class Shape {
    // Attributes common to all shapes
    String color;
    boolean filled;

    // Print common shape details
    public void print() {
        System.out.println("Shape -> Color: " + color + ", Filled: " + filled);
    }
}

// Circle inherits Shape
class Circle extends Shape {
    double radius;

    // Constructor for Circle (no super used)
    public Circle(String c, boolean f, double r) {
        color = c;       // directly assigning parent attributes
        filled = f;      // directly assigning parent attributes
        radius = r;      // own attribute
    }

    // Print circle details
    public void printCircle() {
        System.out.println("Circle -> Color: " + color +
                           ", Filled: " + filled +
                           ", Radius: " + radius);
    }
}

// Triangle inherits Shape
class Triangle extends Shape {
    double base;
    double height;

    // Constructor for Triangle (no super used)
    public Triangle(String c, boolean f, double b, double h) {
        color = c;       // directly assigning parent attributes
        filled = f;      // directly assigning parent attributes
        base = b;        // own attribute
        height = h;      // own attribute
    }

    // Print triangle details
    public void printTriangle() {
        System.out.println("Triangle -> Color: " + color +
                           ", Filled: " + filled +
                           ", Base: " + base +
                           ", Height: " + height);
    }
}

public class Ex3 {
    public static void main(String[] args) {
        // Create Circle and Triangle objects
        Circle circle = new Circle("Red", true, 5.5);
        Triangle triangle = new Triangle("Blue", false, 4.0, 6.0);

        // Print shape details
        circle.printCircle();
        triangle.printTriangle();
    }
}
