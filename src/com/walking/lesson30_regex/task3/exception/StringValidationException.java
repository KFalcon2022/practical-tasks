package com.walking.lesson30_regex.task3.exception;

public class StringValidationException extends RuntimeException {
    public StringValidationException(String message, String s) {
        super(message + s);
    }
}
