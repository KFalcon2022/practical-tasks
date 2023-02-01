package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {

    private String name;
    private int size;
    private DataType type;

    public File(String name, int size, DataType type) {
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

    public DataType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("File: %s, size: %d, type: %s", name, size, type.getName());
    }
}
