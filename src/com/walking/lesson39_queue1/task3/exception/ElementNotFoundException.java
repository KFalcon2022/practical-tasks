package com.walking.lesson39_queue1.task3.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super("Desired element not found");
    }
}