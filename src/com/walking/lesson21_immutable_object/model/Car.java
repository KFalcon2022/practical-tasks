package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public final class Car {
    private final String model;
    private final String number;
    private final int year;
    private final String color;

    private final int hashcode;

    public Car(String model, String number, int year, String color) {
        this.model = model;
        this.number = number;
        this.year = year;
        this.color = color;

        hashcode = hashCode();
    }

    public String getName() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return Objects.equals(model, car.model) && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashcode);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
