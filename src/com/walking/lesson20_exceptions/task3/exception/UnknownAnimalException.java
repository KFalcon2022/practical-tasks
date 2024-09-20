package com.walking.lesson20_exceptions.task3.exception;

import java.lang.RuntimeException;

public class UnknownAnimalException extends RuntimeException {
    private String message;

    public UnknownAnimalException(String message) {
        super(message);
    }
}
