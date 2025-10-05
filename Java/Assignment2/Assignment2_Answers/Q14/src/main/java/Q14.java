/*
 ============================================================================
 Name        : Q14
 Copyright   : Edges For Training
 Description : Combine inheritance and method overloading.
 ============================================================================
 */

class Shape {
    void draw() {
        System.out.println("Drawing Shape");
    }
}

class Circle extends Shape {
    void draw(int radius) {
        System.out.println("Drawing Circle with radius: " + radius);
    }
}

public class Q14 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.draw();      // parent method
        c.draw(5);     // overloaded method
    }
}
