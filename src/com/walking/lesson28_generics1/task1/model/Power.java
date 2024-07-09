package com.walking.lesson28_generics1.task1.model;

public class Power<T extends Number> {
    private T value;
    public Power(T value){
        this.value=value;
    }
    public T getPower(int power){
        Double temp=value.doubleValue();
        for (int i=2; i<=power;i++){
            temp=temp*value.doubleValue();
        }
        value=(T)temp;
        return value;
    }
}
