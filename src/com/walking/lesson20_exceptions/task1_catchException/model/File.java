package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
    private String name;
    private int size;
    FileType type;

    public File(String name, int size, FileType type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "File{" + "name='" + name + '\'' + ", size=" + size + ", type=" + type + '}';
    }
}
