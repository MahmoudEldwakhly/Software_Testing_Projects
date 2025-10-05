/*
 ============================================================================
 Name        : Lab7 (Inheritance Example with print() function)
 Copyright   : Edges For Training
 Description : Demonstrates inheritance and custom print() methods instead
               of overriding toString(). No use of 'super' or 'this'.
 ============================================================================
 */

class Product {
    private String company;
    private double price;
    private int quantitySold;

    // Default constructor
    public Product() {
        company = "";
        price = 0;
        quantitySold = 0;
    }

    // Setter for company
    public void setCompany(String companyName) {
        company = companyName;
    }

    // Setter for price
    public void setPrice(double productPrice) {
        price = productPrice;
    }

    // Increment quantity sold
    public void sell() {
        quantitySold++;
    }

    // Getters
    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    // print() method to display product information
    public void print() {
        System.out.println("Company: " + company +
                           ", Price: " + price +
                           ", Quantity Sold: " + quantitySold);
    }
}

// Television inherits Product
class Television extends Product {
    private String model;

    // Constructor for Television (NO super used)
    public Television(String modelName, String manufacturerName, double productPrice) {
        setCompany(manufacturerName);  // setting parent data
        setPrice(productPrice);        // setting parent data
        model = modelName;             // setting Television-specific data
    }

    // print() method for Television
    public void print() {
        System.out.println("Company: " + getCompany() +
                           ", Price: " + getPrice() +
                           ", Quantity Sold: " + getQuantitySold() +
                           ", Model: " + model);
    }
}

public class Lab7 {
    public static void main(String[] args) {
        // Create Television object
        Television tv = new Television("A32-4K", "Samsung", 24999.99);

        // Simulate sales
        tv.sell();
        tv.sell();
        tv.sell();

        // Print details using print() function
        tv.print();
    }
}
