package com.walking.lesson29_generics2.task2;

public class NumDegree<T extends Number> {
    private T num;

    public NumDegree(T num) {
        this.num = num;
    }

    public double doThis(int n){
        return Math.pow(num.doubleValue(), n);

    }
}
