package com.walking.lesson28_generics1.task1.model;

public class GenericNumber<T extends Number> {
    private T num;

    public void setNum(T num) {
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
