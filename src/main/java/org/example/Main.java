package org.example;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean runApp;
        boolean availableOption;
        int num1;
        int num2;
        int operation;
        String intParsedToString;

            do {
                runApp = true;
                printOptions();
                operation = scanner.nextInt();
                availableOption = (operation >= 0) && (operation <=4);

                intParsedToString = String.valueOf(operation);
                while (!isInteger(intParsedToString) || !availableOption) {
                    System.out.println("Invalid input. Please try again.");
                    printOptions();
                    operation = scanner.nextInt();
                    availableOption = (operation >= 0) && (operation <=4);
                }

                if (operation == 0) {
                    System.out.println("Turning off Calculator...");
                    TimeUnit.SECONDS.sleep(3);
                    runApp = false;
                }

                if (runApp) {

                    do {
                        System.out.println("Enter first number: ");
                        num1 = scanner.nextInt();
                        intParsedToString = String.valueOf(num1);
                    } while (!isInteger(intParsedToString));
                    do {
                        System.out.println("Enter second number: ");
                        num2 = scanner.nextInt();
                        intParsedToString = String.valueOf(num2);
                    } while (!isInteger(intParsedToString));

                    switch (operation) {
                        case 1:
                            calculate(num1, num2, "+");
                            break;
                        case 2:
                            calculate(num1, num2, "-");
                            break;
                        case 3:
                            calculate(num1, num2, "*");
                            break;
                        case 4:
                            calculate(num1, num2, "/");
                            break;
                        default:
                            System.out.println("Something went wrong. Please try again");
                    }
                }

            } while (runApp);

    }
    
    public static void printOptions() {
        System.out.println("Options:");
        System.out.println("1 : Addition\n2 : Subtraction\n3 : Multiply\n4 : Divide\n0 : Exit");
        System.out.print("Choose Option hand hit ENTER: ");
    }
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println(s + ": is not a valid input. Try again, please.");
            return false;
        }
        return true;
    }

    public static void calculate(int num1, int num2, String operation) {
        switch (operation) {
            case "+" -> System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
            case "-" -> System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
            case "*" -> System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
            case "/" -> System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
            default -> System.out.println("Something went wrong");
        }
    }
}
