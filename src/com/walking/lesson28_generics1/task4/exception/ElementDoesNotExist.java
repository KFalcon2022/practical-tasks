package com.walking.lesson28_generics1.task4.exception;

public class ElementDoesNotExist extends RuntimeException{
    public ElementDoesNotExist(String message) {
        super(message);
    }
}
