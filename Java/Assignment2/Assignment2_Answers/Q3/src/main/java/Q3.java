/*
 ============================================================================
 Name        : Q3
 Copyright   : Edges For Training
 Description : Demonstrate method overriding using Vehicle and Car.
 ============================================================================
 */

class Vehicle {
    void display() {
        System.out.println("This is a Vehicle");
    }
}

class Car extends Vehicle {
    @Override
    void display() {
        System.out.println("This is a Car");
    }
}

public class Q3 {
    public static void main(String[] args) {
        // Polymorphism: Vehicle reference -> Car object
        Vehicle v = new Car();
        v.display(); // calls overridden method
    }
}
