package com.walking.lesson28_generics1.task4.exception;

public class NoElement extends RuntimeException {
    public NoElement() {
        super("Элемент не найден.");
    }
}
