package com.walking.lesson38_comparing.task2;

import java.util.Objects;

public class Car implements Comparable<Car>{
    private final ImmutableVariables variables;
    private final String carMake;
    private final String model;

    private int hashCode;

    public Car(String carMake, String model, String carNumber, int year) {
        this.variables = new ImmutableVariables(carNumber, year);
        this.carMake = carMake;
        this.model = model;

        this.hashCode = hashCode();
    }

    public String getCarMake() {
        return carMake;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return variables.getYear() == car.variables.getYear() && Objects.equals(variables.getCarNumber(), car.variables.getCarNumber());
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = variables.getCarNumber().hashCode();
            hashCode = 31 * hashCode + Objects.hashCode(variables.getYear());

        }
        return hashCode;
    }

    @Override
    public String toString() {
        return getCarMake() + " " + getModel() + " " + variables.getCarNumber() + " " + variables.getYear();
    }

    @Override
    public int compareTo(Car car) {
        if (this.variables.getCarNumber().compareTo(car.variables.getCarNumber()) == 0) {
            return this.variables.getYear() - car.variables.getYear();
        }

        return this.variables.getCarNumber().compareTo(car.variables.getCarNumber());
    }
}
