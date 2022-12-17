package com.walking.lesson29_generics2.task2.model;

public class NumberExponentiater<T extends Number> {
    private final T number;

    public NumberExponentiater(T number) {
        this.number = number;
    }

    //    Обратите внимание. В конструктор может быть передан null, соответственно,
    //    метод может выбросить NullPointerException
    public double exponentiate(double exponent) {
        return Math.pow(number.doubleValue(), exponent);
    }

    public T getNumber() {
        return number;
    }
}
