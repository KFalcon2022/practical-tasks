package com.walking.lesson28_generics1.task1.model;

public class CustomNumber<T extends Number> {
    private final T value;

    public CustomNumber(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double pow(double exponent) {
        return Math.pow(value.doubleValue(), exponent);
    }
}
