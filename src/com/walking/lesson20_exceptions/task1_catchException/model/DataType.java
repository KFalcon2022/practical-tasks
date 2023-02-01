package com.walking.lesson20_exceptions.task1_catchException.model;

public enum DataType {
    TEXT("Text"),
    IMAGE("Images"),
    AUDIO("Audio"),
    VIDEO("Video");

    private final String name;

    DataType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
