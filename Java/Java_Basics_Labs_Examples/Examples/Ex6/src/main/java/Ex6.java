/*
 ============================================================================
 Name        : Ex6
 Copyright   : Edges For Training
 Description : This program defines methods for basic arithmetic operations 
               (addition, subtraction, multiplication, division) and uses 
               a switch statement to perform the selected operation based 
               on user input.
 ============================================================================
 */

import java.util.Scanner;

public class Ex6 {

    // Method to perform addition
    public static double add(double x, double y)
    {
        return x + y;
    }

    // Method to perform subtraction
    public static double subtract(double x, double y)
    {
        return x - y;
    }

    // Method to perform multiplication
    public static double multiplay(double x, double y)
    {
        return x * y;
    }

    // Method to perform division
    public static double divide(double x, double y)
    {
        return x / y;
    }

    public static void main(String[] args) {
        // Declare variables for the first and second numbers, result, and operator
        double First_number, Second_number, Result;
        char operand;

        // Create a scanner object to take input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first number
        System.out.println("Enter The First Number");
        First_number = input.nextDouble();

        // Prompt the user to enter the operand (operator)
        System.out.println("Enter The Operand");
        operand = input.next().charAt(0);

        // Prompt the user to enter the second number
        System.out.println("Enter The Second Number");
        Second_number = input.nextDouble();

        // Perform the appropriate operation based on the input operator
        switch (operand)
        {
            case '+':
                // If the operator is '+', call the add method
                Result = add(First_number, Second_number);
                break;
            case '-':
                // If the operator is '-', call the subtract method
                Result = subtract(First_number, Second_number);
                break;        
            case '*':
                // If the operator is '*', call the multiplay method
                Result = multiplay(First_number, Second_number);
                break;
            case '/':
                // If the operator is '/', call the divide method
                Result = divide(First_number, Second_number);
                break;
            default:
                // If an invalid operator is entered, display an error message
                System.out.println("Wrong Operand");
                Result = 0;
                break;
        }

        // Display the result of the operation
        System.out.println(First_number + " " + operand + " " + Second_number + " = " + Result);
    }
}
