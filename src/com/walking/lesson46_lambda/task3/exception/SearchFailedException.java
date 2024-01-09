package com.walking.lesson46_lambda.task3.exception;

public class SearchFailedException extends RuntimeException{
    private static final String MESSAGE="\nThere are no data for your request. Try again!";
    private final String inputSearchText;
    public SearchFailedException(String inputSearchText){
        super(MESSAGE);
        this.inputSearchText=inputSearchText;
    }
}
