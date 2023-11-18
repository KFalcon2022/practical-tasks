package com.walking.lesson30_regex.task3.exception;

public class notMatchedException extends RuntimeException{
    public notMatchedException() {
        super("String not matched template");
    }
}
