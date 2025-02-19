package com.walking.lesson46_lambda.task1;

import java.util.Objects;

public class Car {
    private final String carMake;
    private String carNumber;
    private final int year;
    private String color;
    private boolean actualRegistration;

    private final int hashCode;

    public Car(String carMake, String carNumber, int year, String color, boolean actualRegistration) {
        this.carMake = carMake;
        this.carNumber = carNumber;
        this.year = year;
        this.color = color;
        this.actualRegistration = actualRegistration;
        this.hashCode = hashCode();
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setActualRegistration(boolean actualRegistration) {
        this.actualRegistration = actualRegistration;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getColor() {
        return color;
    }

    public boolean isActualRegistration() {
        return actualRegistration;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && hashCode == car.hashCode && Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber, year, hashCode);
    }

    @Override
    public String toString() {
        return carMake + " " + " " + carNumber + " " + year + " " + color + " " + actualRegistration;
    }
}
