package com.walking.lesson20_exceptions.task3.exceptions;

public class UnknownAnimalException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public UnknownAnimalException(String message) {
        this.message = message;
    }
}
