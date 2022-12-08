package com.walking.lesson20_exceptions.task3.exception;

public class ArrayValidationException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public ArrayValidationException(int number) {
        this.number = number;
    }
}
