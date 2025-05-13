package com.walking.lesson28_generics1.task1.service;

public class GenericNum<T extends Number> {
    private T num;

    public void setNum(T num) {
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
