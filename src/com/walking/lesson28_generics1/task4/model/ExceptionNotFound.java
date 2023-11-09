package com.walking.lesson28_generics1.task4.model;

public class ExceptionNotFound extends RuntimeException{
    public ExceptionNotFound () {
        super("Element not found");
    }
}
