package com.walking.lesson33_files_2.task1.model;

import java.util.Objects;
public class Car {
    private final String number;
    private final int year;

    private Color color;
    private boolean fine;

    private int hashCode;

    public Car(String number, int year, Color color, boolean fine) {
        this.number = number;
        this.year = year;
        this.color = color;
        this.fine = fine;
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean hasFine() {
        return fine;
    }

    public void setFine(boolean fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "number: %s | year: %d | color: %-6s | fine: %s"
                .formatted(number, year, color.getName(), fine ? "+" : "-");
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
