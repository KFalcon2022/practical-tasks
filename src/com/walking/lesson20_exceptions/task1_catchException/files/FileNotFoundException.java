package com.walking.lesson20_exceptions.task1_catchException.files;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(String message) {
        super(message);
    }
}
