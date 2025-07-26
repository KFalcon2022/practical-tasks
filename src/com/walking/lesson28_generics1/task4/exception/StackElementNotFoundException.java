package com.walking.lesson28_generics1.task4.exception;

public class StackElementNotFoundException extends RuntimeException {
    public StackElementNotFoundException() {
        super("Element in this stack not found");
    }
}
