package com.walking.lesson20_exceptions.task1_throwsException.model;

public class File {
    private String fileName;
    private FileType fileType;
    private int fileSize;

    public File(String fileName, FileType type, int size) {
        this.fileName = fileName;
        this.fileType = type;
        this.fileSize = size;
    }

    public String getFileName() {
        return fileName;
    }

    public FileType getFileType() {
        return fileType;
    }

    public int getFileSize() {
        return fileSize;
    }

    @Override
    public String toString(){
        return fileName + " " +
                fileType + " " +
                fileSize;
    }
}
