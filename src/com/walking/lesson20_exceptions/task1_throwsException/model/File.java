package com.walking.lesson20_exceptions.task1_throwsException.model;

import com.walking.lesson20_exceptions.task1_catchException.model.FileTypes;

public class File {
    private String name;
    private int size;
    private com.walking.lesson20_exceptions.task1_catchException.model.FileTypes fiteType;

    public File(String name, int size, com.walking.lesson20_exceptions.task1_catchException.model.FileTypes fiteType) {
        this.name = name;
        this.size = size;
        this.fiteType = fiteType;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public FileTypes getFiteType() {
        return fiteType;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", fiteType=" + fiteType +
                '}';
    }
}
