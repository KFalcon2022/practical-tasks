package com.walking.lesson29_wildcard.task2.model;

public class GenericNumber<T extends Number> {

    private T number;

    public GenericNumber(T number) {
        this.number = number;
    }

    public double pow(int power) {
        return Math.pow(number.doubleValue(), power);
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }
}
