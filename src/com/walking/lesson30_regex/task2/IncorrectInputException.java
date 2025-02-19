package com.walking.lesson30_regex.task2;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException() {

        super("Data entered incorrectly");
    }
}
