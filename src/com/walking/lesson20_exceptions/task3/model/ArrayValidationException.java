package com.walking.lesson20_exceptions.task3.model;

public class ArrayValidationException extends RuntimeException{
    public ArrayValidationException( String message, int index)
    {
        super(message + " " + index);
    }
}
