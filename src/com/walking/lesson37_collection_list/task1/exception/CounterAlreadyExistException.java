package com.walking.lesson37_collection_list.task1.exception;

public class CounterAlreadyExistException extends RuntimeException {
    private final String name;

    public CounterAlreadyExistException(String name) {
        super("Счётчик с названием '%s' уже существует.".formatted(name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
