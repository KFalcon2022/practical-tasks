package com.walking.lesson28_generics1.task3.exception;

public class SearchException extends RuntimeException {
    public SearchException() {
        super("Элемент не найден");
    }
}
