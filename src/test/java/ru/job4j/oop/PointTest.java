package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when100to250then15() {
        double expected = 15;
        int x1 = 10;
        int y1 = 0;
        int x2 = 25;
        int y2 = 0;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when0100to30050then304dot13() {
        double expected = 304.13;
        int x1 = 0;
        int y1 = 100;
        int x2 = 300;
        int y2 = 50;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when10000to0500then10012dot49() {
        double expected = 10012.49;
        int x1 = 10000;
        int y1 = 0;
        int x2 = 0;
        int y2 = 500;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.01);
    }
}