package com.walking.lesson28_generics1.task4.model;

public class Stack<T extends Object> {
    private final T[] array;

    public Stack(T[] array) {
        this.array = array;
    }

    public void addToStack(T... objects) {
        int arrayLength = getArray().length + objects.length;
    }

    public T[] getArray() {
        return array;
    }

    public String toString(int i) {
        return array[i].toString();
    }
}
