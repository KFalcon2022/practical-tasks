package com.walking.lesson32_files_1.task3.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String message, String arguments) {
        super("Not allowed argument. " + message + arguments);
    }
}
