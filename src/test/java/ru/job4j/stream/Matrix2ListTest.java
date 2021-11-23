package ru.job4j.stream;

import junit.framework.TestCase;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Matrix2ListTest extends TestCase {
    public void testConvert() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        Matrix2List mtl = new Matrix2List();
        List<Integer> rsl = mtl.convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }
}
