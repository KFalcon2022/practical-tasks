package com.walking.lesson61_synchronized.exception;

public class UnableParsingException extends RuntimeException {
    public UnableParsingException(String message, String value) {
        super("%s %s".formatted(message, value));
    }
}