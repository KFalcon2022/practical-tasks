package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public class Car {
    private final CarSpecification carSpecification;
    private String licensePlate;

    public Car(CarSpecification carSpecification, String licensePlate) {
        this.carSpecification = carSpecification;
        this.licensePlate = licensePlate;
    }

    public Car(String brand, String model, String color, String licensePlate) {
        this(new CarSpecification(brand, model, color), licensePlate);
    }

    @Override
    public String toString() {
        return " %s, license plate: %s".formatted(carSpecification.toString(), licensePlate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        if (car.carSpecification.equals(this.carSpecification)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carSpecification);
    }
}
