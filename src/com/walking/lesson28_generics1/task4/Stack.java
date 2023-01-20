package com.walking.lesson28_generics1.task4;

public class Stack<T> {
    private T[] array;

    public Stack(T[] array) {
        this.array = array;
    }

    public T[] addElement(T element) {
        int length = array.length;
        T[] newArray = (T[]) new Object[length + 1];

        for (int i = 0; i < (length - 1); i++) {
            newArray[i] = array[i];
        }

        newArray[length] = element;

        return newArray;
    }

    public T[] deleteElement() {
        int length = array.length;
        T[] newArray =(T[]) new Object[length - 1];

        for (int i = 0; i < (length - 1); i++) {
                if (array[i] == null) {
                    throw new NullPointerException();
                } else {
                    newArray[i] = array[i];
                }
            }

        return newArray;
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
