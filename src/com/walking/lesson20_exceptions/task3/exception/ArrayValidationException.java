package com.walking.lesson20_exceptions.task3.exception;

public class ArrayValidationException extends NullPointerException {
    public ArrayValidationException() {
    }

    public ArrayValidationException(String message) {
        super(message);
    }
}
