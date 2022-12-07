package com.walking.lesson20_exceptions.task3.exceptions;

public class ArrayValidationException extends NullPointerException {
    private int number;

    public int getNumber() {
        return number;
    }

    public ArrayValidationException(int number) {
        this.number = number;
    }
}
