package com.walking.lesson20_exceptions.task1_catchException.model;

public enum DataType {
    TEXT("Text"),
    IMAGE("Images"),
    AUDIO("Audio"),
    VIDEO("Video");

    private final String type;

    DataType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
