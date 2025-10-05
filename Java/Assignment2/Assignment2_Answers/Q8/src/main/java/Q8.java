/*
 ============================================================================
 Name        : Q8
 Copyright   : Edges For Training
 Description : Demonstrate final class that cannot be inherited.
 ============================================================================
 */

final class Constants {
    static final double E = 2.718;
}

// class ExtendedConstants extends Constants {} // ❌ Compilation Error

public class Q8 {
    public static void main(String[] args) {
        System.out.println("Value of E: " + Constants.E);
    }
}
