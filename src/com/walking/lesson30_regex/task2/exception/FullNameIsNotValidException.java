package com.walking.lesson30_regex.task2.exception;

public class FullNameIsNotValidException extends RuntimeException {
    public FullNameIsNotValidException(String message) {
        super(message);
    }
}
