package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] findedItems = new Item[size];
        int length = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                findedItems[i] = items[i];
                length++;
            }
        }
        return Arrays.copyOf(findedItems, length);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}
