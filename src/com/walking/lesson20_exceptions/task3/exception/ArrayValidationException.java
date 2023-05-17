package com.walking.lesson20_exceptions.task3.exception;

public class ArrayValidationException extends Exception{
    private int index;

    public ArrayValidationException(int index) {
        super("Wrong array index");
        this.index = index;
    }

    public ArrayValidationException() {
    }

    public ArrayValidationException(String message) {
        super(message);
    }

    public ArrayValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayValidationException(Throwable cause) {
        super(cause);
    }

    public ArrayValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getIndex() {
        return index;
    }
}
