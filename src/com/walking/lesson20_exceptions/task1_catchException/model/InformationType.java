package com.walking.lesson20_exceptions.task1_catchException.model;

public enum InformationType {
    TXT(".txt"),
    JPG(".jpg"),
    MP3(".mp3"),
    MP4(".mp4");

    private final String type;

    InformationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
