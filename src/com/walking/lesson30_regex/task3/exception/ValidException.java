package com.walking.lesson30_regex.task3.exception;

public class ValidException extends RuntimeException {
    public ValidException(String message, String regex) {
        super("%s не подходит к %s".formatted(message, regex));
    }
}
