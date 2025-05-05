package com.walking.lesson32_files_1.task1;

import java.util.Objects;

public class Car {
    private final String carMake;
    private final String model;
    private final String carNumber;
    private final int year;

    private int hashCode;

    public Car(String carMake, String model, String carNumber, int year) {
        this.carMake = carMake;
        this.model = model;
        this.carNumber = carNumber;
        this.year = year;

        this.hashCode = hashCode();
    }

    public String getCarMake() {
        return carMake;
    }

    public String getModel() {
        return model;
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
        return year == car.year && Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = carNumber.hashCode();
            hashCode = 31 * hashCode + Objects.hashCode(year);

        }
        return hashCode;
    }

    @Override
    public String toString() {
        return carMake + " " + model + " " + carNumber + " " + year;
    }

}
