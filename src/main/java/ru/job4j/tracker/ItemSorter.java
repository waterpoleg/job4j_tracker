package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(3, "Java", LocalDateTime.now()),
                new Item(1, "Python", LocalDateTime.now()),
                new Item(2, "C#", LocalDateTime.now()),
                new Item(9, "Basic", LocalDateTime.now())
        );
        System.out.println(items);
        Collections.sort(items, new ItemAscByName());
        System.out.println(items);
        Collections.sort(items, new ItemDescByName());
        System.out.println(items);
    }
}
