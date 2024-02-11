package com.walking.lesson30_regex.task3.exception;

public class InvalidTextException extends RuntimeException{
    public InvalidTextException(String text){
        super("Invalid symbols in text: "+text);
    }
}
