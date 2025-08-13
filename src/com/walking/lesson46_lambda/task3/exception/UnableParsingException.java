package com.walking.lesson46_lambda.task3.exception;

public class UnableParsingException extends RuntimeException{
    public UnableParsingException(String message, String value) {
        super("%s %s".formatted(message, value));
    }
}
