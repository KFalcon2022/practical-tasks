package com.walking.lesson21_immutable_object.model;

import java.util.Objects;
public class Car {
    private final CarProperty property;

    public Car(String number, String model) {
        this.property = new CarProperty(number, model);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(property, car.property);
    }

    @Override
    public int hashCode() {
        return property.hashCode();
    }

    @Override
    public String toString() {
        return "Car\n" + property.toString();
    }
}


