package com.walking.lesson30_regex.task3.exception;

public class InvalidWordException extends RuntimeException {
    public InvalidWordException(String invalidWord) {
        super("некорректный вариант слова: " + invalidWord);
    }
}
