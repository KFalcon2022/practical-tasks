package com.walking.lesson25_nested_classes.task1.static_class.exception;

public class UnknownShapeException extends RuntimeException {
    public UnknownShapeException(String message) {
        super(message);
    }
}
