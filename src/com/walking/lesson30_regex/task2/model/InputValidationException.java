package com.walking.lesson30_regex.task2.model;

public class InputValidationException extends RuntimeException{
    public InputValidationException() {
        super("Invalid string full name");
    }
}
