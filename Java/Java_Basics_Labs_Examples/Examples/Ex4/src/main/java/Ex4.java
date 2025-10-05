/*
 ============================================================================
 Name        : Ex4
 Copyright   : Edges For Training
 Description : This program performs basic arithmetic operations (+, -, *, /) 
               based on user input. It asks for two numbers and an operator 
               and then calculates and displays the result.
 ============================================================================
 */

import java.util.Scanner;

public class Ex4 {
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
        switch (operand) {
            case '+':
                // If the operator is '+', perform addition
                Result = First_number + Second_number;
                break;
            case '-':
                // If the operator is '-', perform subtraction
                Result = First_number - Second_number;
                break;        
            case '*':
                // If the operator is '*', perform multiplication
                Result = First_number * Second_number;
                break;
            case '/':
                // If the operator is '/', perform division
                Result = First_number / Second_number;
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
