package com.walking.lesson43_map.task2.model;

import java.util.Objects;

public class Car {
    private final String number;
    private final int year;

    private String color;
    private Boolean actualTechnicalInspection;

    private int hashcode;

    public Car(String number, int year, String color, Boolean actualTechnicalInspection) {
        this.number = number;
        this.year = year;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;

        hashcode = hashCode();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
        this.actualTechnicalInspection = actualTechnicalInspection;
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

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    public int getHashcode() {
        return hashcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
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
        return "Car -> %s; %d; %s; %s \n".formatted(number, year, color,
                actualTechnicalInspection ? "actual" : "not actual");
    }
}
