package com.walking.lesson34_date_time.task3.exception;

public class InputValidationException extends RuntimeException {
    public InputValidationException(String actual, String expected, Throwable cause) {
        super("The value %s was received, when %s was expected".formatted(actual, expected), cause);
    }
}
