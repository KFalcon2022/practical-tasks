package com.walking.lesson30_regex.task2.exeption;

public class InvalidFullNameException extends RuntimeException {
    public InvalidFullNameException() {
        super("Имя указано некорректно.");
    }
}
