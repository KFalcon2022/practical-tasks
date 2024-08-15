package com.walking.lesson30_regex.task3.exception;

public class InvalidWordsException extends RuntimeException {
    public InvalidWordsException(String words) {
        super("Invalid words: " + words);
    }
}
