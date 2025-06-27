package com.walking.lesson20_exceptions.task3.exeptions;

public class ArrayValidationException extends RuntimeException {
    public ArrayValidationException (int index) {
        super(index + " item in array is null");
    }
}
