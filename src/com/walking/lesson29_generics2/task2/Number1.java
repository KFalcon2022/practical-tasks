package com.walking.lesson29_generics2.task2;

public class Number1<T extends Number> {
    private T value;

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Number1{" +
                "value=" + value +
                '}';
    }

    public Number1(T value) {
        this.value = value;
    }

    public double getPow(double i) {
        return Math.pow(value.doubleValue(), i);
    }
}
