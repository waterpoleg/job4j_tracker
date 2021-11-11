package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle superBus = new SuperBus();
        Vehicle[] vehicles = new Vehicle[] {airplane, train, superBus};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
