package com.walking.lesson27_generics.task1.model;

import com.walking.lesson27_generics.task1.Main;

public class GenericNumber<T extends Number> {

    private final T number;

    public GenericNumber(T number) {
        this.number = number;
    }

    public double pow(int power) {
        return Math.pow(number.doubleValue(), power);
    }
 }
