package com.walking.lesson20_exceptions.task1_throwsException.model;

public class File {
    private String name;
    private int size;
    private TypeFile typeFile;

    public File(String name, int size, TypeFile typeFile)
    {
        this.name = name;
        this.size = size;
        this.typeFile = typeFile;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", typeFile=" + typeFile +
                '}';
    }
}
