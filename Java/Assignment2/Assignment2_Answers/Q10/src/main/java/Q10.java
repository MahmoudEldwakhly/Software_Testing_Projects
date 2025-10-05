/*
 ============================================================================
 Name        : Q10
 Copyright   : Edges For Training
 Description : Demonstrate constructor chaining using this().
 ============================================================================
 */

class Product {
    String name;
    double price;

    Product() {
        this("Unknown", 0.0); // constructor chaining
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Product: " + name + ", Price: " + price);
    }
}

public class Q10 {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product("Laptop", 800.0);
        p1.display();
        p2.display();
    }
}
