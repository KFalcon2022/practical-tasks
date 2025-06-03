package com.walking.lesson29_generics2.task2.model;

public class NumberExponentiation<T extends Number> {
    private final T number;

    public NumberExponentiation(T value) {
        this.number = value;
    }

    public T getNumber() {
        return number;
    }

    public double exponentiation(double exponent) {
        return Math.pow(number.doubleValue(), exponent);
    }
}
