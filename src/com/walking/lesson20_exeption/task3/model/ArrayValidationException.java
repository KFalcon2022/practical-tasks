package com.walking.lesson20_exeption.task3.model;

public class ArrayValidationException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public ArrayValidationException(String message, int number) {

        super(message);
        this.number = number;
    }
}
