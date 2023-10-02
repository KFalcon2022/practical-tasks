package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
    private String name;
    private int size;
    private final FileType fileType;

    public File(String name, int size, FileType fileType) {
        this.name = name;
        this.size = size;
        this.fileType = fileType;
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

    public FileType getFileType() {
        return fileType;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        File searchingFile = (File) obj;

        if (name.equals(searchingFile.name)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Файл - " + name + ", тип файла - " + fileType.getName() + ", размер - " + size;
    }
}
