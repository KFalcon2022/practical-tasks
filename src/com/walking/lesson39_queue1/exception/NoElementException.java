package com.walking.lesson39_queue1.exception;

public class NoElementException extends RuntimeException {
    public NoElementException() {
        super("Элемент не найден.");
    }
}
