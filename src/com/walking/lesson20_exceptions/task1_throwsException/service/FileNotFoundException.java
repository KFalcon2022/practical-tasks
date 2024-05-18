package com.walking.lesson20_exceptions.task1_throwsException.service;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(String message) {
        super(message);
    }
}
