package com.walking.lesson20_exceptions.task2.model;

import java.util.InputMismatchException;

public class InputValidationException extends InputMismatchException {
    private String message;

    public String getMessage() {
        return message;
    }

    public InputValidationException(String message) {
        this.message = message;
    }
}
