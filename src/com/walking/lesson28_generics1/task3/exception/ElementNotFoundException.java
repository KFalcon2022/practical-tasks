package com.walking.lesson28_generics1.task3.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super("Element not found");
    }
}
