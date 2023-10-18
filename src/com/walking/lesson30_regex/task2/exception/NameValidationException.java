package com.walking.lesson30_regex.task2.exception;

public class NameValidationException extends RuntimeException {
    public NameValidationException(String name){
        super("You entered invalid name: "+ name);
    }
}
