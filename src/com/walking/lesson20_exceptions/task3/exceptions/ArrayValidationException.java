package com.walking.lesson20_exceptions.task3.exceptions;

public class ArrayValidationException extends Exception{
    private int errorPosition;
    public ArrayValidationException(String message, int position){
        super(message);
        errorPosition=position;
        System.out.println("EMPTY ELEMENT IN ARRAY!");
        getErrorPosition();
    }
    private void getErrorPosition(){
        System.out.println("Error position is: "+errorPosition);
    }
}
