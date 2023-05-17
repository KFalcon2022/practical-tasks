package com.walking.lesson20_exceptions.task1_catchException.model;

public enum FileType {
    TEXT("Text"),
    IMAGE("Image"),
    AUDIO("Audio"),
    VIDEO("Video");

    private final String description;
    FileType(String decription) {
        this.description = decription;
    }

    public String getDescription(){
        return this.description;
    }
}
