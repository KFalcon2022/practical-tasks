package com.walking.lesson28_generics1.task4.exception;

public class ValueNotFoundException extends RuntimeException {
    private static final String MESSAGE="You entered nonexistent value!";
    public ValueNotFoundException(){
        super(MESSAGE);
    }
}
