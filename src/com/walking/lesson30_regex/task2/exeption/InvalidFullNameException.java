package com.walking.lesson30_regex.task2.exeption;

public class InvalidFullNameException extends RuntimeException {
    public InvalidFullNameException(String message) {
        super(message);
    }
}
