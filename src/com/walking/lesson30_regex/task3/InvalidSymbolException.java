package com.walking.lesson30_regex.task3;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException() {
        super("Слово содержит некорректный символ");
    }
}
