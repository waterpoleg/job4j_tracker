package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import static org.junit.Assert.*;

public class ItemSorterTest {
    @Test
    public void sort() {
        List<Item> items = Arrays.asList(
                new Item(3, "Java", LocalDateTime.now()),
                new Item(1, "Python", LocalDateTime.now()),
                new Item(2, "C#", LocalDateTime.now()),
                new Item(9, "Basic", LocalDateTime.now())
        );
        List<Item> expected = Arrays.asList(
                new Item(9, "Basic", LocalDateTime.now()),
                new Item(2, "C#", LocalDateTime.now()),
                new Item(3, "Java", LocalDateTime.now()),
                new Item(1, "Python", LocalDateTime.now())
        );
        Collections.sort(items);
        assertEquals(items, expected);
    }

    @Test
    public void sortByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "Java", LocalDateTime.now()),
                new Item(1, "Python", LocalDateTime.now()),
                new Item(2, "C#", LocalDateTime.now()),
                new Item(9, "Basic", LocalDateTime.now())
        );
        List<Item> expected = Arrays.asList(
                new Item(9, "Basic", LocalDateTime.now()),
                new Item(2, "C#", LocalDateTime.now()),
                new Item(3, "Java", LocalDateTime.now()),
                new Item(1, "Python", LocalDateTime.now())
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(items, expected);
    }

    @Test
    public void sortReverse() {
        List<Item> items = Arrays.asList(
                new Item(3, "Java", LocalDateTime.now()),
                new Item(1, "Python", LocalDateTime.now()),
                new Item(2, "C#", LocalDateTime.now()),
                new Item(9, "Basic", LocalDateTime.now())
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Python", LocalDateTime.now()),
                new Item(3, "Java", LocalDateTime.now()),
                new Item(2, "C#", LocalDateTime.now()),
                new Item(9, "Basic", LocalDateTime.now())
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(items, expected);
    }
}