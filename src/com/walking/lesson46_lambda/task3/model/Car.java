package com.walking.lesson46_lambda.task3.model;

public class Car {
    private final ImmutableVariables variables;
    private final String color;


    public Car(String carMake, String color, String carNumber, int year) {
        this(new ImmutableVariables(carMake, carNumber, year), color);
    }

    public Car(ImmutableVariables variables, String color) {
        this.variables = variables;
        this.color = color;
    }

    public ImmutableVariables getVariables() {
        return variables;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return variables.getCarMake() + " " + getColor() + " " + variables.getCarNumber() + " " + variables.getYear();
    }
}
