package com.walking.lesson33_files_2.model;

import java.util.Objects;

public class Car {
    private String model;
    private String number;
    private int year;
    private String color;
    private long hashcode;

    public Car(String model, String number, int year, String color) {
        this.model = model;
        this.number = number;
        this.year = year;
        this.color = color;
        hashcode = hashCode();
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
        return Objects.hash(model, number);
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }
}
