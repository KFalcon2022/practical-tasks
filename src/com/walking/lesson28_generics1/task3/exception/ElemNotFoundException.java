package com.walking.lesson28_generics1.task3.exception;

public class ElemNotFoundException extends RuntimeException{
    public ElemNotFoundException() {
        super("Element not found");
    }
}
