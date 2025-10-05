/*
 ============================================================================
 Name        : Q11
 Copyright   : Edges For Training
 Description : Demonstrate super keyword to access parent variable.
 ============================================================================
 */

class Animal2 {
    String type = "General Animal";
}

class Cat extends Animal2 {
    String type = "Cat";

    void printType() {
        System.out.println("Child type: " + type);
        System.out.println("Parent type: " + super.type);
    }
}

public class Q11 {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.printType();
    }
}
