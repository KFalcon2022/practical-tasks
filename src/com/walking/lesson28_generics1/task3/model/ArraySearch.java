package com.walking.lesson28_generics1.task3.model;

public class ArraySearch<T> {
    private final T array[];

    public ArraySearch(T[] array) {
        this.array = array;
    }

    public T search(T desired){
        for (int i = 0; i < array.length; i++){
            if (array[i].equals(desired)){
                return array[i];
            }
        }
        return null;
    }
}
