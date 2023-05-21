package com.walking.lesson28_generics1.task4.exception;

public class StackIsEmptyException extends RuntimeException{
    public StackIsEmptyException() {
        super("Stack is empty");
    }
}
