package com.walking.lesson20_exceptions.task3.exeptions;

public class UnknownAnimalException extends Exception{
    public UnknownAnimalException (String message) {
        super(message);
    }
}
