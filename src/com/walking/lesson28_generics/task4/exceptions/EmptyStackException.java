package com.walking.lesson28_generics.task4.exceptions;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException(String message) {
        super(message);
    }
}
