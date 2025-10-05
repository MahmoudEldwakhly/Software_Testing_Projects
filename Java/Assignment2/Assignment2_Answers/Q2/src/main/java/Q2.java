/*
 ============================================================================
 Name        : Q2
 Copyright   : Edges For Training
 Description : Create a class Animal with a method eat(). 
               Inherit Dog from Animal and add bark() method.
 ============================================================================
 */

class Animal {
    // Method in the parent class
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    // Method in the child class
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Q2 {
    public static void main(String[] args) {
        // Create Dog object
        Dog d = new Dog();
        d.eat();  // inherited method
        d.bark(); // child method
    }
}
