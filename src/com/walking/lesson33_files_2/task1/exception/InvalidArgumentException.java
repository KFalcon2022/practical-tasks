package com.walking.lesson33_files_2.task1.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String message, String arguments) {
        super("Not allowed argument. " + message + arguments);
    }
}
