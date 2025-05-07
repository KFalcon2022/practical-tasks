package com.walking.lesson20_exceptions.task1_catchException.model;

import static java.lang.String.format;

public class File {
    private String name;
    private int size;
    private Type type;

    public File(String name, int size, Type type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return format("File name: %s, size: %d, type: %s", name, size, type);
    }
}
