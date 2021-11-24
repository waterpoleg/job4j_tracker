package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void sortAsc() {
        List<String> input = Arrays.asList("k1", "k2/sk2", "k1/sk1/ssk2", "k1/sk1", "k2");
        List<String> expect = List.of("k1", "k1/sk1", "k1/sk1/ssk2", "k2", "k2/sk2");
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void sortDesc() {
        List<String> input = Arrays.asList("k1", "k2/sk2", "k1/sk1/ssk2", "k1/sk1", "k2");
        List<String> expect = List.of("k2", "k2/sk2", "k1", "k1/sk1", "k1/sk1/ssk2");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}
