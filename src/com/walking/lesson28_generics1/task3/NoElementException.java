package com.walking.lesson28_generics1.task3;

public class NoElementException extends RuntimeException {
    public NoElementException() {
        super("Element not found");
    }
}
