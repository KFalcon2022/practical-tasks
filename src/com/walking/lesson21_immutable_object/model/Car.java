package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public class Car {
    private final CarId carId;

    private String color;
    private boolean hasFine;

    public Car(String owner, int serialNumber, String color, boolean hasFine) {
        this.carId = new CarId(owner, serialNumber);
        this.color = color;
        this.hasFine = hasFine;
    }

    public Car(CarId carId, String color, boolean hasFine) {
        this.carId = carId;
        this.color = color;
        this.hasFine = hasFine;
    }

    public CarId getCarId() {
        return carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean hasFine() {
        return hasFine;
    }

    public void setHasFine(boolean hasFine) {
        this.hasFine = hasFine;
    }

    @Override
    public String toString() {
        return """
                owner: %s
                serialNumber: %d
                color: %s
                hasFine: %s
                """.formatted(carId.getOwner(), carId.getSerialNumber(), color, hasFine ? "has" : "hasn't");
    }

    @Override
    public int hashCode() {
        return carId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }

        Car car = (Car) obj;

        return Objects.equals(carId, car.carId);
    }
}
