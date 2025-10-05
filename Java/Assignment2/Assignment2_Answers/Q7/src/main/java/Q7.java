/*
 ============================================================================
 Name        : Q7
 Copyright   : Edges For Training
 Description : Demonstrate final method that cannot be overridden.
 ============================================================================
 */

class Parent {
    final void show() {
        System.out.println("Final method in Parent");
    }
}

class Child extends Parent {
    // void show() {} // This would cause a compilation error
}

public class Q7 {
    public static void main(String[] args) {
        new Child().show();
    }
}
