/*
 ============================================================================
 Name        : Q12
 Copyright   : Edges For Training
 Description : Demonstrate super() constructor call.
 ============================================================================
 */

class Vehicle2 {
    Vehicle2(String brand) {
        System.out.println("Vehicle brand: " + brand);
    }
}

class Truck extends Vehicle2 {
    Truck(String brand) {
        super(brand); // calls parent constructor
    }
}

public class Q12 {
    public static void main(String[] args) {
        Truck t = new Truck("Volvo");
    }
}
