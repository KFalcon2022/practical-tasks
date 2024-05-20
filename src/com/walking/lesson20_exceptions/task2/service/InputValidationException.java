package com.walking.lesson20_exceptions.task2.service;

public class InputValidationException extends RuntimeException{
    public InputValidationException(String message) {
        super(message);
    }
}
