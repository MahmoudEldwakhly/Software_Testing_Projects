/*
 ============================================================================
 Name        : Q9
 Copyright   : Edges For Training
 Description : Demonstrate this keyword to differentiate variables.
 ============================================================================
 */

class Employee {
    String name;

    Employee(String name) {
        this.name = name; // 'this' differentiates instance and parameter
    }

    void display() {
        System.out.println("Employee name: " + name);
    }
}

public class Q9 {
    public static void main(String[] args) {
        Employee e = new Employee("Sarah");
        e.display();
    }
}
