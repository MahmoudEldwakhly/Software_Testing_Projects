/*
 ============================================================================
 Name        : Lab11
 Copyright   : Edges For Training
 Description : Demonstrates the use of an interface in Java. 
               The interface Car has a method printPowerType() that is 
               implemented by different car types (GasCar).
 ============================================================================
 */

// Interface definition
interface Car {
    // Abstract method to be implemented by all car types
    void printPowerType();
}

// Gas powered car class implementing Car interface
class GasCar implements Car {
    @Override
    public void printPowerType() {
        System.out.println("This car runs on Gas.");
    }
}

public class Lab11 {
    public static void main(String[] args) {
        // Create an object of GasCar type using interface reference
        Car car1 = new GasCar();

        // Demonstrate overridden method
        car1.printPowerType();
    }
}
