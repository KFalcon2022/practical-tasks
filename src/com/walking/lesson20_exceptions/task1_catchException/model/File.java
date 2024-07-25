package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
    private String fileName;
    private long fileSize;
    private TypeInformation typeInformation;

    public File(String fileName, long fileSize, TypeInformation typeInformation) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.typeInformation = typeInformation;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", typeInformation=" + typeInformation +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public TypeInformation getTypeInformation() {
        return typeInformation;
    }

    public void setTypeInformation(TypeInformation typeInformation) {
        this.typeInformation = typeInformation;
    }
}
