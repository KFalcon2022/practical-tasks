package com.walking.lesson20_exceptions.task2.exceptions;

public class InputValidationException extends RuntimeException{
    private static final String uniMessage = "\nWrong input data!\n";
    private int inputValue;
    public InputValidationException(String message, int inputValue){
        super(message);
        System.out.println(uniMessage);
        this.inputValue=inputValue;
    }
    public int getInputValue(){
        System.out.print("Input Value: ");
        return inputValue;
    }
}
