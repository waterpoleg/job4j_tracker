package ru.job4j.ex;

import org.junit.Test;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenArgumentLessThenZero() {
        Fact fact = new Fact();
        fact.calc(-1);
    }
}
