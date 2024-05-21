package com.walking.lesson20_exceptions.task3.exeptions;

public class ArrayValidationException extends RuntimeException {
    private int index;
    public ArrayValidationException (String message, int index) {
        super(message);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
