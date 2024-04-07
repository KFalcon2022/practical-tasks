package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public class Car {
    private final String color;
    private final String brand;
    private final String number;
    private final CarIndetifier carIndetifier;

    public Car(String color, String brand, String number, CarIndetifier carIndetifier) {
        this.color = color;
        this.brand = brand;
        this.number = number;
        this.carIndetifier = carIndetifier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carIndetifier, car.carIndetifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carIndetifier);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", number='" + number + '\'' +
                ", VIN_number='" + carIndetifier + '\'' +
                '}';
    }

    public boolean equalsCar(String VIN) {
        return this.carIndetifier.getVIN_number().equals(VIN);
    }

    public CarIndetifier getCarIndetifier() {
        return carIndetifier;
    }
}

