package com.walking.lesson28_generics1.task4;

import java.util.Arrays;

public class Stack<T> {
    private T[] array;

    public Stack(T[] array) {
        this.array = array;
    }

    public T[] addElement(T element) {
        int length = array.length;

        array = Arrays.copyOf(array, length + 1);

        array[length] = element;

        return array;
    }

    public T[] deleteElement() {
        array = Arrays.copyOf(array, array.length - 1);

        return array;
    }

    public int getSize() {
        return array.length;
    }

    public String[] toStringArray() {
        int length = array.length;
        String[] StringArray = new String[length];

        for (int i = 0; i < length; i++) {
            StringArray[i] = String.valueOf(array[i]);
        }

        return StringArray;
    }
}
