package ru.job4j.oop;

public class Max {
    public static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static int max(int x, int y, int z) {
        return max(max(x, y), z);
    }

    public static int max(int x, int y, int z, int t) {
        return max(max(x, y, z), t);
    }
}
