package com.walking.lesson20_exceptions.task3.exceptions;

public class ArrayValidationException extends NullPointerException {
    public ArrayValidationException(String message) {
        super(message);
    }
}
