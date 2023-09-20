package com.walking.lesson20_exceptions.task3.model;

public class ArrayValidationException extends NullPointerException {
    private int i;

    public ArrayValidationException(int index) {
        this.i = index;
    }

    @Override
    public String toString() {
        return "Индекс массива " + i + " содержит пустое значение.";
    }
}
