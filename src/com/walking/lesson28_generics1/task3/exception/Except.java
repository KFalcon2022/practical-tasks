package com.walking.lesson28_generics1.task3.exception;

public class Except extends RuntimeException {
    public Except() {
        super("Значение не найдено");
    }
}
