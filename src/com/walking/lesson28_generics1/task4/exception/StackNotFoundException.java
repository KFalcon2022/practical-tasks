package com.walking.lesson28_generics1.task4.exception;

public class StackNotFoundException extends RuntimeException {
    public StackNotFoundException(String message) {
        super(message);
    }
}
