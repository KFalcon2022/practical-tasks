package com.walking.lesson32_files_1.task2;

import java.util.Objects;

public class Car {
    private final String brand;
    private final String number;
    private final int year;

    private String color;
    private boolean actualTechnicalInspection;

    private int hashcode;

    public Car(String name, String number, int year, String color, boolean actualTechnicalInspection) {
        this.brand = name;
        this.number = number;
        this.year = year;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
        this.hashcode = hashCode();
    }

    public String getBrand() {
        return brand;
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
        return """
                brand: %s
                number: %s
                year: %d
                color: %s
                actualTechnicalInspection: %s
                """.formatted(brand,
                number, year, color,
                actualTechnicalInspection ? "true" : "false");
    }
}
