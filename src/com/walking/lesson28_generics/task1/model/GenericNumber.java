package com.walking.lesson28_generics.task1.model;

public class GenericNumber<T extends Number> {

    private final T number;

    public GenericNumber(T number) {
        this.number = number;
    }

    public double pow(int power) {
        return Math.pow(number.doubleValue(), power);
    }
 }
