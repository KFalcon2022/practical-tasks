package com.walking.lesson29_generics2.task2.model;

public class GenericClass<T extends Number> {
    private final T number;

    public GenericClass(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double getNumberExponente(double power) {
        return Math.pow(this.number.doubleValue(), power);
    }
}
