package com.walking.lesson29_generics2.task2.model;

public class GenNumber<T extends Number> {

    private final T number;

    public GenNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double calcPower(double power) {
        return Math.pow(number.doubleValue(), power);
    }
}
