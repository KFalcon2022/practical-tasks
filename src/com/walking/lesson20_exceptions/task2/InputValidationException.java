package com.walking.lesson20_exceptions.task2;

public class InputValidationException extends RuntimeException{
    public InputValidationException(String message){
        super(message);
    }
}
