package org.example;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int num1;
        int num2;
        int operation;

        while (true) {
            System.out.println("Welcome to the CALCULATOR ! ! !");
            printOptions();
            operation = userInput(1);
            if (operation == 0) {
                System.out.println("Turning off Calculator...");
                TimeUnit.SECONDS.sleep(2);
                break;
            }
            System.out.print("Enter first number: ");
            num1 = userInput(2);
            System.out.print("Enter second number: ");
            num2 = userInput(3);

            calculate(num1, num2, operation);
        }
    }

    public static void printOptions() {
        System.out.println("Options:");
        System.out.println("1 : Addition\n2 : Subtraction\n3 : Multiply\n4 : Divide\n0 : Exit");
        System.out.print("Choose Option and hit ENTER: ");
    }

    public static int userInput(int inputEntryNr) {
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        String instruction;
        String inputValue = null;
        int validatedValue;

        while (!validInput) {
            inputValue = input.nextLine();
            try {
                validatedValue = Integer.parseInt(inputValue);
                if (inputEntryNr == 1) {
                    validInput = validOptionInput(validatedValue);
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("\"" + inputValue + "\"" + " : is not a valid input. Try again, please.");
                if (inputEntryNr == 1) {
                    printOptions();
                } else {
                    instruction = (inputEntryNr == 2) ? "Enter first number: " : "Enter second number: ";
                    System.out.print(instruction);
                }
            }
        }
        return Integer.parseInt(inputValue);
    }

    public static boolean validOptionInput(int option) {
        if ((option < 0) || (option > 4)) {
            System.out.println(option + ": is not a valid input. Try again, please.");
            printOptions();
            return false;
        }
        return true;
    }

    public static void calculate(int num1, int num2, int operation) throws InterruptedException {
        String resultString = "Result -> ";
        switch (operation) {
            case 1 -> System.out.println(resultString + num1 + " + " + num2 + " = " + (num1 + num2));
            case 2 -> System.out.println(resultString + num1 + " - " + num2 + " = " + (num1 - num2));
            case 3 -> System.out.println(resultString + num1 + " * " + num2 + " = " + (num1 * num2));
            case 4 -> System.out.println(resultString + num1 + " / " + num2 + " = " + (num1 / num2));
            default -> System.out.println("Something went wrong");
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Starting new Calculator session...");
        TimeUnit.SECONDS.sleep(2);
    }
}
