package com.walking.lesson19_object_methods.model;

import java.util.Objects;

public class Car {
    private final String owner;
    private final int serialNumber;

    private String color;
    private boolean hasFine;

    private int hashCode;

    public Car(String owner, int serialNumber, String color, boolean hasFine) {
        this.owner = owner;
        this.serialNumber = serialNumber;
        this.color = color;
        this.hasFine = hasFine;
        this.hashCode = hashCode();
    }

    public String getOwner() {
        return owner;
    }

    public int getSerialNumber() {
        return serialNumber;
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
                """.formatted(owner, serialNumber, color, hasFine ? "has" : "hasn't");
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = owner.hashCode();
            hashCode += 31 * serialNumber;
        }

        return hashCode;
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

        return serialNumber == car.serialNumber && Objects.equals(owner, car.owner);
    }
}
