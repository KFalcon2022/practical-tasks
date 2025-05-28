package com.walking.lesson29_generics2.task2.service;

public class GenericNumber<T extends Number> {
    private final T num;

    public GenericNumber(T num) {
        this.num = num;
    }

    public T getNum() {
        return num;
    }

    public double getPow(double pow) {
        double number = num.doubleValue();

        return Math.pow(number, pow);
    }
}
