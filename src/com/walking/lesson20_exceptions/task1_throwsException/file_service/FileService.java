package com.walking.lesson20_exceptions.task1_throwsException.file_service;

import com.walking.lesson20_exceptions.task1_catchException.model.File;

import java.io.FileNotFoundException;

public class FileService {
    private final File[] fileArray;

    public FileService(File[] file) {
        this.fileArray = file;
    }

    public File searchFile(String fileName) throws FileNotFoundException {
        for (File file1 : fileArray) {
            if (file1.getName().equals(fileName)) {
                return file1;
            }
        }
        throw new FileNotFoundException("File not found");
    }
}
