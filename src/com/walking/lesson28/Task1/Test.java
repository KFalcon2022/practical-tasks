package com.walking.lesson28.Task1;

public class Test<T extends Number>{
    private T value;

    public Test(T value){
        this.value = value;
    }

    public double getDegree(int degree){
        double result = 1;
        for (int i = 0; i < degree; i++){
            result *= value.doubleValue();
        }
        return result;
    }
}
