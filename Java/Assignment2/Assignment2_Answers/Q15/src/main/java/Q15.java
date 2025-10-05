/*
 ============================================================================
 Name        : Q15
 Copyright   : Edges For Training
 Description : Library Management System demonstrating 
               inheritance, static, final, this, super, and overloading.
 ============================================================================
 */

class LibraryItem {
    String title;
    int itemId;
    static int itemCount = 0;
    final String libraryName = "Central Library";

    // Constructor
    LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        itemCount++;
    }

    // Final method
    final void displayLibraryInfo() {
        System.out.println("Library Name: " + libraryName);
    }
}

class Book extends LibraryItem {
    String author;

    // Constructor using super and this
    Book(String title, int itemId, String author) {
        super(title, itemId);     // call parent constructor
        this.author = author;     // differentiate variable
    }

    // Method overloading
    void displayInfo() {
        System.out.println("Title: " + title + ", ID: " + itemId + ", Author: " + author);
    }

    void displayInfo(boolean detailed) {
        if (detailed) {
            System.out.println("Detailed Info:");
            System.out.println("Title: " + title);
            System.out.println("ID: " + itemId);
            System.out.println("Author: " + author);
        } else {
            displayInfo();
        }
    }
}

public class Q15 {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", 101, "John Doe");

        b1.displayLibraryInfo();  // final method from parent
        b1.displayInfo();         // normal method
        b1.displayInfo(true);     // overloaded method
        System.out.println("Total Library Items: " + LibraryItem.itemCount);
    }
}
