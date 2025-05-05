package com.walking.lesson38_comparing.task2;

public final class ImmutableVariables {

    private final String carNumber;
    private final int year;

    public String getCarNumber() {
        return carNumber;
    }

    public int getYear() {
        return year;
    }

    public ImmutableVariables(String carNumber, int year) {
        this.carNumber = carNumber;
        this.year = year;
    }
}
