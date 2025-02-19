package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
    private String fileName;
    private final FileType fileType;
    private int fileSize;

    public File(String fileName, FileType fileType, int fileSize){
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    @Override
    public String toString(){
        return fileName + " " +
                fileType + " " +
                fileSize;
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
}
