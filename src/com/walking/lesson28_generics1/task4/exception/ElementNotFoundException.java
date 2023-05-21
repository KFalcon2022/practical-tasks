package com.walking.lesson28_generics1.task4.exception;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException() {
        super( "Element not found!" );
    }
}
