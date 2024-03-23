package com.walking.lesson20_exceptions.task2.exceptions;

public class InputValidationException extends RuntimeException{

    public InputValidationException(String message) {
        super(message);
    }
}
