package com.walking.lesson20_exceptions.task1_throwsException.model;

public class File {
    private String name;
    private int size;
    private InformationType type;

    public File(String name, int size, InformationType type) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public InformationType getType() {
        return type;
    }

    public void setType(InformationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "File %s%s size: %d".formatted(getName(), type.getType(), getSize());
    }
}
