package ru.job4j.stream;

public class Car {
    private String vendor;
    private String model;
    private String engineType;
    private int color;
    private boolean isAvailable;

    static class Builder {
        private String vendor;
        private String model;
        private String engineType;
        private int color;
        private boolean isAvailable;

        Builder buildVendor(String vendor) {
            this.vendor = vendor;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        Builder buildColor(int color) {
            this.color = color;
            return this;
        }

        Builder buildIsAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.vendor = vendor;
            car.model = model;
            car.engineType = engineType;
            car.color = color;
            car.isAvailable = isAvailable;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car: { " + vendor + " : "
                + model + " : "
                + engineType + " : "
                + color + " : "
                + isAvailable + " }";
    }

    public static void main(String[] args) {
        Car car = new Builder().buildVendor("GAZ")
                .buildModel("Super Charger")
                .buildEngineType("diesel")
                .buildColor(255)
                .buildIsAvailable(false)
                .build();
        System.out.println(car);
    }
}