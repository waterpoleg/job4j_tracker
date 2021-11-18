package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import static org.junit.Assert.*;

public class ItemSorterTest {
    @Test
    public void sort() {
        List<Item> items = Arrays.asList(
                new Item(3, "Java"),
                new Item(1, "Python"),
                new Item(2, "C#"),
                new Item(9, "Basic")
        );
        List<Item> expected = Arrays.asList(
                new Item(9, "Basic"),
                new Item(2, "C#"),
                new Item(3, "Java"),
                new Item(1, "Python")
        );
        Collections.sort(items);
        assertEquals(items, expected);
    }

    @Test
    public void sortByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "Java"),
                new Item(1, "Python"),
                new Item(2, "C#"),
                new Item(9, "Basic")
        );
        List<Item> expected = Arrays.asList(
                new Item(9, "Basic"),
                new Item(2, "C#"),
                new Item(3, "Java"),
                new Item(1, "Python")
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(items, expected);
    }

    @Test
    public void sortReverse() {
        List<Item> items = Arrays.asList(
                new Item(3, "Java"),
                new Item(1, "Python"),
                new Item(2, "C#"),
                new Item(9, "Basic")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Python"),
                new Item(3, "Java"),
                new Item(2, "C#"),
                new Item(9, "Basic")
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(items, expected);
    }
}