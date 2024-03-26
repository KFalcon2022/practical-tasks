package com.walking.lesson28_generics1.task3.utility;

public class ElementNotFoundException extends RuntimeException {
    private final String value;

    public ElementNotFoundException(String message, String value) {
        super(message);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
