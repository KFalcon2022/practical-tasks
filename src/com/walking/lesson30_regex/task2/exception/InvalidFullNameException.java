package com.walking.lesson30_regex.task2.exception;

public class InvalidFullNameException extends RuntimeException {
    public InvalidFullNameException(String invalidFullName) {
        super("Невозможно распознать введенное имя: " + invalidFullName);
    }
}
