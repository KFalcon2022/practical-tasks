package com.walking.lesson25_nested_classes.task1.static_class.model;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
