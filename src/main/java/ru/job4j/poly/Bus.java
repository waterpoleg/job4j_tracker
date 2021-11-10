package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Go!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("there are " + count + " passengers on the bus");
    }

    @Override
    public double fuelPrice(float fuelCount) {
        return fuelCount * 48.5;
    }
}
