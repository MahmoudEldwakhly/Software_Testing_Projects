/*
 ============================================================================
 Name        : Q5
 Copyright   : Edges For Training
 Description : Demonstrate static method (square) without object creation.
 ============================================================================
 */

class MathUtils {
    static int square(int number) {
        return number * number;
    }
}

public class Q5 {
    public static void main(String[] args) {
        System.out.println("Square of 5: " + MathUtils.square(5));
    }
}
