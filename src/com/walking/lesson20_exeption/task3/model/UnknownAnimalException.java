package com.walking.lesson20_exeption.task3.model;

public class UnknownAnimalException extends Exception{
    private String className;

    public String getClassName() {
        return className;
    }

    public UnknownAnimalException(String message, String className) {

        super(message);
        this.className = className;
    }
}
