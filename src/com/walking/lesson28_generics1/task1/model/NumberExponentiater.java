package com.walking.lesson28_generics1.task1.model;

public class NumberExponentiater<T extends Number>{
    private T number;
    public NumberExponentiater(T number){
        this.number = number;
    }
    public double exponentiate(double power){
        return Math.pow(number.doubleValue(),power);
    }
}
