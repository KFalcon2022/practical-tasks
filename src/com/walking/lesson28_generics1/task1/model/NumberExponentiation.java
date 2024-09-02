package com.walking.lesson28_generics1.task1.model;

public class NumberExponentiation<T extends Number> {
    private final T number;

    public NumberExponentiation(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double exponentiation(double exponent) {
        return Math.pow(number.doubleValue(), exponent);
    }
}
