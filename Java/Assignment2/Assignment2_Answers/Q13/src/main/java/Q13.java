/*
 ============================================================================
 Name        : Q13
 Copyright   : Edges For Training
 Description : Demonstrate method overloading with add().
 ============================================================================
 */

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Q13 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("Sum of ints: " + c.add(5, 7));
        System.out.println("Sum of doubles: " + c.add(5.5, 7.3));
    }
}
