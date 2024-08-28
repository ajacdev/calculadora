package com.example;

import java.util.Scanner;

public class Calculator 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println( "Ingrese un numero" );
        double num1 = scanner.nextDouble();
        System.out.println( "Ingrese otro numero" );
        double num2 = scanner.nextDouble();
        System.out.print("Introduce la operación (+, -, *, /): ");
        char operacion = scanner.next().charAt(0);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}
