package com.walking.lesson29_generics2.task2.model;

public class NumberExponentiater<T extends Number> {
    private final T number;

    public NumberExponentiater(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double exponentiate(double exponent) {
        return Math.pow(number.doubleValue(), exponent);
    }

    @Override
    public String toString() {
        return "exponent{" +
                "number=" + number +
                '}';
    }
}
