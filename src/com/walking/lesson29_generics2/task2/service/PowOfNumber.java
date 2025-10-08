package com.walking.lesson29_generics2.task2.service;

public class PowOfNumber<N extends Number> {
    private final N num;

    public PowOfNumber(N num) {
        this.num = num;
    }

    public N getNum() {
        return num;
    }

    public double sqr(double pow) {
        return Math.pow(num.doubleValue(), pow);
    }
}
