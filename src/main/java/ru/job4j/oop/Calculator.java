package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int n) {
        return sum(n) + minus(n) + multiply(n) + divide(n);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(sum(5));
        System.out.println(minus(5));
        System.out.println(calculator.multiply(5));
        System.out.println(calculator.divide(5));
        System.out.println(calculator.sumAllOperation(5));
    }
}