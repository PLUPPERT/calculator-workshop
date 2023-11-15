package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runApp = true;
        int num1;
        int num2;
        int operation;



        System.out.println("Enter first number");
        num1 = scanner.nextInt();
        System.out.println("Enter second number");
        num2 = scanner.nextInt();
        System.out.println("Choose operation");
        System.out.println("1 : Addition\n2 : Subtraction\n3 : Multiply\n4 : Divide\n0 : Exit");
    }
}