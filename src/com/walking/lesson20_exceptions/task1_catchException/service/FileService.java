package com.walking.lesson20_exceptions.task1_catchException.service;

import com.walking.lesson20_exceptions.task1_catchException.model.File;

import java.io.FileNotFoundException;

public class FileService {
    private final File[] files;

    public FileService(File[] files) {
        this.files = files;
    }

    public File findFile(String name) throws FileNotFoundException {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
                // Всё сделал сам, но не додумался в методе поменять throw и return местами в медоте(
            }
        }
        throw new FileNotFoundException("File not found");
    }
}
