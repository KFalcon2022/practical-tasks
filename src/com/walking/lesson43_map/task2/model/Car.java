package com.walking.lesson43_map.task2.model;

import java.util.Objects;

public class Car {
    private final String number;
    private final int year;
    private String color;
    private boolean actualTechnicalInspection;

    public Car(String number, int year, String color, boolean actualTechnicalInspection) {
        this.number = number;
        this.year = year;
        this.color = color;
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

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != (o.getClass())) {
            return false;
        }

        Car car = (Car) o;

        return getYear() == car.getYear() && Objects.equals(getNumber(), car.getNumber());
    }

    @Override
    public int hashCode() {
            int hashcode = number.hashCode();
            hashcode += 31 * year;

        return hashcode;
    }

    @Override
    public String toString() {
        return """
                number: %s
                year: %d
                color: %s
                actualTechnicalInspection: %s
                """.formatted(
                number, year, color,
                actualTechnicalInspection ? "actual" : "not actual");
    }
}
