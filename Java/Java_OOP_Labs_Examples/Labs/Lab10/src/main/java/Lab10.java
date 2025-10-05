/*
 ============================================================================
 Name        : Lab10
 Copyright   : Edges For Training
 Description : Demonstrates the use of 'super' and 'this' keywords in Java.
               - 'this' is used to refer to current class variables and methods.
               - 'super' is used to refer to parent class variables and methods.
 ============================================================================
 */

class Vehicle {
    String brand;

    // Constructor
    public Vehicle(String brand) {
        this.brand = brand; // 'this' refers to Vehicle's instance variable
    }

    // Method
    public void displayInfo() {
        System.out.println("Vehicle Brand: " + brand);
    }
}

class Car extends Vehicle {
    String brand;  // hides the parent brand variable

    // Constructor using 'super' and 'this'
    public Car(String parentBrand, String childBrand) {
        super(parentBrand);    // calls parent constructor to initialize parent brand
        this.brand = childBrand; // refers to Car's own brand variable
    }

    // Overriding method and using 'super' and 'this'
    @Override
    public void displayInfo() {
        System.out.println("Child class brand using 'this': " + this.brand);
        System.out.println("Parent class brand using 'super': " + super.brand);

        System.out.print("Calling parent class method using 'super': ");
        super.displayInfo(); // calls parent method
    }
}

public class Lab10 {
    public static void main(String[] args) {
        // Create Car object
        Car car = new Car("Toyota", "Corolla");

        // Display information using overridden method
        car.displayInfo();
    }
}
