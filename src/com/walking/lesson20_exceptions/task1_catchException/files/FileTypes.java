package com.walking.lesson20_exceptions.task1_catchException.files;

public enum FileTypes {
    TEXT(".txt"),
    VIDEO(".avi"),
    AUDIO(".mp3"),
    IMAGE(".jpg");

    private String type;

    FileTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
