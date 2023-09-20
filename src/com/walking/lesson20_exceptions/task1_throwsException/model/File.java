package com.walking.lesson20_exceptions.task1_throwsException.model;

import com.walking.lesson20_exceptions.task1_catchException.model.FileType;

public class File {
    private final String name;
    private final int size;
    FileType fileType;

    public File(String name, int size, FileType fileType) {
        this.name = name;
        this.size = size;
        this.fileType = fileType;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        File searchingFile = (File) obj;

        if (name.equals(searchingFile.name)) return true;

        return false;
    }

    @Override
    public String toString() {
        return "Файл - " + name + ", тип файла - " + fileType.toString() + ", размер - " + size;
    }
}
