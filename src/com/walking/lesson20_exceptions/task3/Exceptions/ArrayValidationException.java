package com.walking.lesson20_exceptions.task3.Exceptions;

public class ArrayValidationException extends RuntimeException {


    public ArrayValidationException(int i) {
        super("Null element in array. Element's number: " + i);
    }

}
