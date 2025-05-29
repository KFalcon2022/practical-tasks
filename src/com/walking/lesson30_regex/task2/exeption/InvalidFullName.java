package com.walking.lesson30_regex.task2.exeption;

public class InvalidFullName extends RuntimeException {
    public InvalidFullName(String message) {
        super(message);
    }
}
