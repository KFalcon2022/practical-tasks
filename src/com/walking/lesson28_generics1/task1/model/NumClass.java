package com.walking.lesson28_generics1.task1.model;

public class NumClass<T extends Number> {
    private T num;

    public NumClass(T num) {
        this.num = num;
    }

    public T getNum() {
        return num;
    }

    public double toPow(double pow) {
        return Math.pow(num.doubleValue(), pow);
    }
}
