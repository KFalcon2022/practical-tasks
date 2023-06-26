package com.walking.lesson19_object_methods;

import java.util.Objects;

import static java.lang.String.format;

public class Car {
    private final String brand;
    private final String model;
    private final String color;
    private String licensePlate;

    public Car(String brand, String model, String color, String licensePlate) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return format("Brand: %s, model: %s, color: %s, license plate: %s"
                , brand, model, color, licensePlate);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof Car)) {
            return false;
        }
        Car car = (Car) other;
        if (car.brand.equals(this.brand) && car.model.equals(this.model)
                && car.color.equals(this.color) && car.licensePlate.equals(this.licensePlate)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, licensePlate);
    }
}
