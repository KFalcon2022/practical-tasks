package com.walking.lesson28_generics1.task1.math;

public class Power<T extends Number> {
    private T base;

    public Power(T base) {
        this.base = base;
    }

    public double toPow(int exponent) {
        double baseD = base.doubleValue();
        return Math.pow(baseD, exponent);
    }

    public T getBase() {
        return base;
    }
}
