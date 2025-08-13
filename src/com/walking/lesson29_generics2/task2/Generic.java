package com.walking.lesson29_generics2.task2;

public class Generic<T extends Number> {
    private T number;

    public Generic(T number) {
        this.number = number;
    }

    public double exponentiateGeneric(double exponent) {

        return Math.pow(number.doubleValue(), exponent);
    }
}
