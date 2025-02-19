package com.walking.lesson43_map.task1.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String message, String regex) {
        super("%s не подходит к %s".formatted(message, regex));
    }
}
