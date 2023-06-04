package com.walking.lesson28_generics1.task1;

public class NumDegree <T extends Number> {
    private T num;

    public NumDegree(T num) {
        this.num = num;
    }

    public double doThis(int n){
        return Math.pow(num.doubleValue(), n);

    }
}
