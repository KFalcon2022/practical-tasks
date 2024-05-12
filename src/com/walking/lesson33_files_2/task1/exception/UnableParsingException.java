package com.walking.lesson33_files_2.task1.exception;

public class UnableParsingException extends RuntimeException {
    public UnableParsingException(String message, String value) {
        super("%s %s".formatted(message, value));
    }
}