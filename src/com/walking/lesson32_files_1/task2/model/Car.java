package com.walking.lesson32_files_1.task2.model;

import java.util.Objects;

public class Car {
    private final String number;
    private final int year;
    private String color;
    private int hashcode;

    public Car(String number, int year, String color) {
        this.number = number;
        this.year = year;
        this.color = color;
        this.hashcode = hashCode();
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

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !getClass().equals(o.getClass())) {
            return false;
        }

        Car car = (Car) o;

        return year == car.year && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            hashcode = number.hashCode();
            hashcode += 31 * year;
        }

        return hashcode;
    }

    @Override
    public String toString() {
        return "%s;%d;%s\n".formatted(number, year, color);
    }
}
