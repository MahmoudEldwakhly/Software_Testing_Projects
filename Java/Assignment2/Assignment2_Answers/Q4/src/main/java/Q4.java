/*
 ============================================================================
 Name        : Q4
 Copyright   : Edges For Training
 Description : Demonstrate static variable to count objects.
 ============================================================================
 */

class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Counter C1 = new Counter();
        Counter C2 = new Counter();
        Counter C3 = new Counter();
        System.out.println("Objects created: " + Counter.count);
    }
}
