package com.walking.lesson28_generics1.task1;

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
