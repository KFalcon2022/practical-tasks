package com.walking.lesson20_exceptions.task3.exceptions;

public class UnknownAnimalException extends RuntimeException{

    public UnknownAnimalException(String message) {
        super(message);
    }
}
