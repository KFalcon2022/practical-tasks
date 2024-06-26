package com.walking.lesson20_exceptions.task3.Exception;

public class ArrayValidationException extends RuntimeException {
    public ArrayValidationException(int arrayIndex){
        super("Array element with index:"+arrayIndex+" is null");
    }
}
