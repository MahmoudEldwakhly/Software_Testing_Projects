/*
 ============================================================================
 Name        : Ex4
 Copyright   : Edges For Training
 Description : Demonstrates inheritance using a normal base class 
               instead of an interface. 
 ============================================================================
 */

// Normal base class
class Car {
    // Method to print power type (default implementation)
    public void printPowerType() {
        System.out.println("Unknown power type.");
    }
}

// Gas powered car class inheriting from Car
class GasCar extends Car {
    public void printPoweGas() {
        System.out.println("This car runs on Gas.");
    }
}

public class Ex4 {
    public static void main(String[] args) {
        // Create object of GasCar type
        GasCar car1 = new GasCar();
        // Demonstrate overridden method
        car1.printPoweGas();
    }
}
