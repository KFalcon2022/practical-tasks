package com.walking.lesson30_regex.task2.exception;

public class ValidException extends RuntimeException {
    public ValidException(String message, String regex) {
        super("%s - совпадений не найдено - %s".formatted(message, regex));
    }
}
