package com.walking.lesson20_exceptions.task1_throwsException.file;

public enum FileType {
    TEXT("текст"),
    VIDEO("видеозапись"),
    AUDIO("аудиозапись"),
    PICTURE("изображение");

    private final String name;

    FileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
