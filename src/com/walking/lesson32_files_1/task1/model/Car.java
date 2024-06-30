package com.walking.lesson32_files_1.task1.model;

import java.util.Objects;

public class Car {
    private final String model;
    private final String number;
    private final int year;
    private final Color color;
    private final long hashcode;

    public Car(String model, String number, int year, Color color) {
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
        return Objects.hashCode(hashcode);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", color=" + color +
                '}';
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

    public Color getColor() {
        return color;
    }
}
