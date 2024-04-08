package com.walking.lesson28_generics1.task4;

public class StackElementNotFoundException extends RuntimeException{
    public StackElementNotFoundException() {
        super("Element not found");
    }
}
