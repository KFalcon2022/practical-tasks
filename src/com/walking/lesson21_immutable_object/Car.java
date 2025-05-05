package com.walking.lesson21_immutable_object;

import java.util.Objects;

public class Car {
    private final ImmutableVariables variables;

    private int hashCode;

    public Car(String carMake, String model, String carNumber, int year) {
        this(new ImmutableVariables(carMake,model,carNumber,year));

        this.hashCode = hashCode();
    }

    public Car(ImmutableVariables variables) {
        this.variables = variables;
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
        return variables.getCarMake() + " " + variables.getModel() + " " + variables.getCarNumber() + " " + variables.getYear();
    }

}
