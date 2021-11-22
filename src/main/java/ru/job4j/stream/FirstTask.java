package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstTask {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, -2, 3, -4, 5, 6, -7, -8, 9));
        System.out.println(list);
        List<Integer> positiveList = list.stream().filter(i -> i > 0).collect(Collectors.toList());
        System.out.println(positiveList);
    }
}
