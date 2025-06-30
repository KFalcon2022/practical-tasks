package com.walking.lesson20_exceptions.task2;

public class InvalidValidationException extends RuntimeException {

    public InvalidValidationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
