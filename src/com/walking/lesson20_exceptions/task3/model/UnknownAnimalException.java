package com.walking.lesson20_exceptions.task3.model;

public class UnknownAnimalException extends ClassNotFoundException {
    private String message;

    public UnknownAnimalException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return this.getMessage() + "\n" + this.getStackTrace();
    }
}
