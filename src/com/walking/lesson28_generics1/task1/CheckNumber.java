package com.walking.lesson28_generics1.task1;

import java.lang.Math.*;

class CheckNumber<T extends Number> {
    private T number;

    public CheckNumber(T number) {
        this.number = number;
    }

    public double doExtent(int num) {

        double result = Math.pow(number.doubleValue(), num);

        return result;
    }
}
