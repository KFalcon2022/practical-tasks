package com.walking.lesson43_map.task1.exception;

public class ValidException extends RuntimeException {
    public ValidException(String message, String regex) {
        super("%s не подходит к %s".formatted(message, regex));
    }
}
