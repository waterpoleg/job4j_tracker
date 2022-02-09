package ru.job4j.tracker;

public class GCTest {
    public static void main(String[] args) {
        double start;
        double finish;
        MemTracker memTracker = new MemTracker();
        start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            memTracker.add(new Item("item #" + i));
        }
        finish = System.currentTimeMillis();
        System.out.printf("%nApp running time: %f%n%n", (finish - start) / 1000);
    }
}
