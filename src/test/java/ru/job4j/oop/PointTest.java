package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when100to250then15() {
        double expected = 15;
        Point a = new Point(10, 0);
        Point b = new Point(25, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when0100to30050then304dot13() {
        double expected = 304.13;
        Point a = new Point(0, 100);
        Point b = new Point(300, 50);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when10000to0500then10012dot49() {
        double expected = 10012.49;
        Point a = new Point(10000, 0);
        Point b = new Point(0, 500);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}