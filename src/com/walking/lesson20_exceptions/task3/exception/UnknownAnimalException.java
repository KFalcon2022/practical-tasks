package com.walking.lesson20_exceptions.task3.exception;

public class UnknownAnimalException extends Exception{
    public UnknownAnimalException() {
    }

    public UnknownAnimalException(String message) {
        super(message);
    }

    public UnknownAnimalException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownAnimalException(Throwable cause) {
        super(cause);
    }

    public UnknownAnimalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
