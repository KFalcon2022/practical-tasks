package com.walking.lesson20_exceptions.task2.exception;

public class InputValidationException extends RuntimeException {

    public InputValidationException() {
        super();
    }

    public InputValidationException(String message) {
        super(message);
    }
}
