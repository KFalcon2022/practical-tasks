package com.walking.lesson28_generics1.task3.exeption;

public class ValueNotFound extends RuntimeException {
    public ValueNotFound(String message) {
        super(message);
    }
}
