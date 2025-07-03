package com.walking.lesson26_string_types.task1.service;

public class UnexpectedNumberException extends RuntimeException {
    public UnexpectedNumberException(String message) {
        super(message);
    }
}
