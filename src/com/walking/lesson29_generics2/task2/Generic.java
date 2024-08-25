package com.walking.lesson29_generics2.task2;

public class Generic<T extends Number> {
    private T number;

    public Generic(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double pow(int power) {
        return Math.pow(number.doubleValue(), power);
    }

}
