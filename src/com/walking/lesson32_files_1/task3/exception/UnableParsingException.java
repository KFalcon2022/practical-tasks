package com.walking.lesson32_files_1.task3.exception;

public class UnableParsingException extends RuntimeException {
    public UnableParsingException(String message, String value) {
        super("%s %s".formatted(message, value));
    }
}