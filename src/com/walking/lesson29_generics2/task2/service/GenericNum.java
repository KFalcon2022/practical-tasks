package com.walking.lesson29_generics2.task2.service;

public class GenericNum<T extends Number> {
    private final T num;

    public GenericNum(T num) {
        this.num = num;
    }

    public T getNum() {
        return num;
    }

    public double getResult(double pow) {
        double number = num.doubleValue();

        return Math.pow(number, pow);
    }
}
