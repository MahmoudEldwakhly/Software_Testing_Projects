/*
 ============================================================================
 Name        : Lab8
 Copyright   : Edges For Training
 Description : Demonstrates inheritance using a normal base class 
               The base class Car has a default method 
               that is overridden by the GasCar class to provide a 
               specific implementation.
 ============================================================================
 */

// Base class
class Car {
    // Default method (can be overridden by child classes)
    public void printPowerType() {
        System.out.println("Unknown power type.");
    }
}

// Gas powered car class inheriting from Car
class GasCar extends Car {
    // Correctly overriding parent method
    @Override
    public void printPowerType() {
        System.out.println("This car runs on Gas.");
    }
}

public class Lab8 {
    public static void main(String[] args) {
        // Create object of GasCar type
        GasCar car1 = new GasCar();

        // Call overridden method
        car1.printPowerType();
    }
}
