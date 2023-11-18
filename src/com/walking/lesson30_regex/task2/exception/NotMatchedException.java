package com.walking.lesson30_regex.task2.exception;

public class NotMatchedException extends RuntimeException{
    public NotMatchedException() {
        super("input not match full name mask ");
    }
}
