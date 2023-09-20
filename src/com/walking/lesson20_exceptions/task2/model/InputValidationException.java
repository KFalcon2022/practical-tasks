package com.walking.lesson20_exceptions.task2.model;

import java.io.IOException;

public class InputValidationException extends IOException {
    private int number;

    public int getNumber() {
        return number;
    }

    public InputValidationException(String message, int number) {
        super(message);
        this.number = number;
    }
}
