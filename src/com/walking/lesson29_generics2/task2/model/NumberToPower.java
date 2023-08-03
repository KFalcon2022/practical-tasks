package com.walking.lesson29_generics2.task2.model;

public class NumberToPower<T extends Number>{
    private T value;

    public NumberToPower(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public double Pow(double pow){
        return Math.pow( value.doubleValue(), pow);
    }
}
