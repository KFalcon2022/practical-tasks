package com.walking.lesson20_exceptions.task1_throwsException.file;

public class File {
    private final String name;
    private final String size;
    private final FileType type;

    public File(String name, String size, FileType type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public FileType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Название файла: " + name + ".\nРазмер файла: " + size + ".\nТип файла: " + type.getName() + ".";
    }
}
