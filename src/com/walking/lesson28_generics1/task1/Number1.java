package com.walking.lesson28_generics1.task1;

public class Number1<T extends Number> {
    private T value;

    public T getValue() {
        return value;
    }

    public Number1(T value) {
        this.value = value;
    }

    public double getPow(double i) {
        return Math.pow(value.doubleValue(), i);
    }
}
