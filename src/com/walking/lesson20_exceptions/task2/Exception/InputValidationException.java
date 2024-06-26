package com.walking.lesson20_exceptions.task2.Exception;

public class InputValidationException extends RuntimeException{
    Reason reason;
    public InputValidationException(Reason reason){
        super("Inserted "+reason);
    }

    public enum Reason{
        WrongType,
        WrongLength
    }
}