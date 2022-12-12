package com.walking.lesson28.Task3;

public class TestArray<T>{

    private T[] values;

    public TestArray(){
        values = null;
    }

    public void setValues(T[] values){
        this.values = values;
    }

    public T find(T needle){
        for (T value: values) {
            if (value.equals(needle)){
                return value;
            }
        }
        throw new RuntimeException("Element not found");
    }
}