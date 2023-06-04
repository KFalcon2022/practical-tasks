package com.walking.lesson20_exceptions.task3;

public class UnknownAnimalException extends Exception{
    public UnknownAnimalException(String message){
        super(message);
    }
}
