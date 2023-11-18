package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
    private final String name;
    private final int size;
    private final FileType type;

    public File(String name, int size, FileType type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name: %s \nSize=%d \nType: %s".formatted(name, size, type.getDescription());
    }

    public String getName() {
        return name;
    }
}
