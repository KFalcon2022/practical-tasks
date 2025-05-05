package com.walking.lesson46_lambda.task3.model;

public final class ImmutableVariables {
    private final String carMake;
    private final String carNumber;
    private final int year;

    public ImmutableVariables(String carMake, String carNumber, int year) {
        this.carMake = carMake;
        this.carNumber = carNumber;
        this.year = year;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getYear() {
        return year;
    }

}
