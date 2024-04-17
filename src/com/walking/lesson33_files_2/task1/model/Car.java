package com.walking.lesson33_files_2.task1.model;

import com.walking.lesson33_files_2.task1.service.CarValidationService;

import java.util.Objects;

public class Car {
    private final String number;
    private final int year;

    private CarColor color;
    private boolean hasFine;

    private int hashCode;

    public Car(String number, int year, CarColor color, boolean hasFine) {
        CarValidationService.validateCarArguments(number, year, color);

        this.number = number;
        this.year = year;
        this.color = color;
        this.hasFine = hasFine;
        this.hashCode = hashCode();
    }

    public String getNumber() {
        return number;
    }


    public int getYear() {
        return year;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
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
        return "number: %s | year: %d | color: %-6s | hasFine: %s"
                .formatted(number, year, color.getTextEn(), hasFine ? "+" : "-");
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = number.hashCode();
            hashCode += 31 * year;
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

        return year == car.year && Objects.equals(number, car.number);
    }
}
