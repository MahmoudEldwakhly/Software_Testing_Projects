/*
 ============================================================================
 Name        : Lab9
 Copyright   : Edges For Training
 Description : Demonstrates the difference between public, private, 
               and protected access modifiers in Java.
 ============================================================================
 */

class Parent {
    // private variable - accessible only inside this class
    private String privateData = "Private Data";

    // protected variable - accessible in this class, subclasses, and same package
    protected String protectedData = "Protected Data";

    // public variable - accessible from anywhere
    public String publicData = "Public Data";

    // public method to access private variable safely
    public void showPrivateData() {
        System.out.println("Accessing private data inside class: " + privateData);
    }
}

class Child extends Parent {
    public void showDataFromChild() {
        // privateData; //  ERROR - cannot access private members directly
        System.out.println("Accessing protected data from child: " + protectedData);
        System.out.println("Accessing public data from child: " + publicData);
    }
}

public class Lab9 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        // Accessing data directly from parent object
        // System.out.println(parent.privateData); //  ERROR - private not accessible
        System.out.println("Accessing public data from main: " + parent.publicData);

        // Accessing protected data (allowed here because same package)
        System.out.println("Accessing protected data from main: " + parent.protectedData);

        // Accessing private data via public method
        parent.showPrivateData();

        // Accessing from child class methods
        child.showDataFromChild();
    }
}
