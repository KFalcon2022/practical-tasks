package com.walking.lesson20_exceptions.task3;

public class ArrayValidationException extends Exception{
    public ArrayValidationException(int arrayIndex){
        super(arrayIndex + "element is null!");
    }
}
