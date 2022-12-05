package com.walking.lesson20_exeption.task2.model;

public class InputValidationException extends Exception{
    private int length;
    public int getLength(){return length;}

    public InputValidationException(String message, int length){

        super(message);
        this.length=length;
    }

}
