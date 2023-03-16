package com.walking.lesson20_exceptions.task1_catchException;

public class File {
    private String name;
    private FileType type;
    private int size;


    File(String name, FileType type, int size){
        this.name = name;
        this.type = type;
        this.size = size;
    }

    File(String name, FileType type){
        this.name = name;
        this.type = type;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (!name.equals(file.name)) return false;
        return type == file.type;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name + "." + type +
                ", size=" + size +
                " bytes";
    }
}
