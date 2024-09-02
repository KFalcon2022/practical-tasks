package com.walking.lesson30_regex.task2.exception;

public class InvalidFullNameException extends RuntimeException {
    public InvalidFullNameException(String input) {
        super("Invalid input format: " + input);
    }
}
