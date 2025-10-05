/*
 ============================================================================
 Name        : Ex3
 Copyright   : Edges For Training
 Description : This program checks the temperature and prints a message based on 
               the temperature range: "too hot," "normal," or "too cold."
 ============================================================================
 */

public class Ex3 {
    public static void main(String[] args) {
        // Define the temperature variable
        int Temprature = 19;

        // Check if the temperature is above 30 and print "it's too hot"
        if (Temprature > 30) {
            System.out.println("it's too hot");
        }
        // Check if the temperature is between 20 and 30 and print "it's normal"
        else if (Temprature > 20 && Temprature <= 30) {
            System.out.println("it's Normal");
        }
        // Check if the temperature is between 10 and 20 and print "it's too cold"
        else if (Temprature > 10 && Temprature <= 20) {
            System.out.println("it's too Cold");
        }    
    }
}
