package ru.job4j.oop;

import static java.lang.Math.*;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        double result = Point.distance(0, 0, 2, 0);
        double result1 = Point.distance(10, 0, 25, 0);
        double result2 = Point.distance(0, 100, 300, 50);
        double result3 = Point.distance(10000, 0, 0, 500);
        System.out.println("result (0, 0) to (2, 0) " + result);
        System.out.println("result (10, 0) to (25, 0) " + result1);
        System.out.println("result (0, 100) to (300, 50) " + result2);
        System.out.println("result (10000, 0) to (0, 500) " + result3);
    }
}