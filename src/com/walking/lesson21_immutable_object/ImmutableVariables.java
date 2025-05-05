package com.walking.lesson21_immutable_object;

public final class ImmutableVariables {
    private final String carMake;
    private final String model;
    private final String carNumber;
    private final int year;

    public ImmutableVariables(String carMake, String model, String carNumber, int year) {
        this.carMake = carMake;
        this.model = model;
        this.carNumber = carNumber;
        this.year = year;
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

}
