package com.walking.lesson20_exceptions.task1_catchException.files;

import com.walking.lesson20_exceptions.task1_catchException.files.types.Type;

public class File {
    private final String name;
    private final int size;
    private final Type type;

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
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}
