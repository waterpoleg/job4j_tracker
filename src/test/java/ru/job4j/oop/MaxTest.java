package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {
    @Test
    public void whenMax5To2Then5() {
        int left = 5;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax25To26Then26() {
        int left = 25;
        int right = 26;
        int result = Max.max(left, right);
        int expected = 26;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax8To8Then8() {
        int left = 8;
        int right = 8;
        int result = Max.max(left, right);
        int expected = 8;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax7To8and10Then10() {
        int x = 7;
        int y = 8;
        int z = 10;
        int result = Max.max(x, y, z);
        int expected = 10;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax15To10and50anMinus66Then66() {
        int x = 15;
        int y = 10;
        int z = 50;
        int t = -66;
        int result = Max.max(x, y, z, t);
        int expected = 50;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax50To50and50and50Then50() {
        int x = 50;
        int y = 50;
        int z = 50;
        int t = 50;
        int result = Max.max(x, y, z, t);
        int expected = 50;
        Assert.assertEquals(result, expected);
    }
}
