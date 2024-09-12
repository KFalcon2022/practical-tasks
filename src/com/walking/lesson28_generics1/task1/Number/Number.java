package com.walking.lesson28_generics1.task1.Number;

public class Number <T  extends java.lang.Number>{
    private T value;
    public Number(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }
    public Double ExponentNumber (double exponent){return Math.pow(value.doubleValue(), exponent);}
}
