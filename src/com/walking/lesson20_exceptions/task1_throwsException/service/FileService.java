package com.walking.lesson20_exceptions.task1_throwsException.service;

import com.walking.lesson20_exceptions.task1_throwsException.model.File;

import java.io.FileNotFoundException;

public class FileService {
    private final File[] files;

    public FileService(File[] files) {
        this.files = files;
    }

    public File findFile(String name) throws FileNotFoundException {
        for (File x : files) {
            if (x.getName().equals(name)) {
                return x;
                // Всё сделал сам, но не додумался в методе поменять throw и return местами в медоте(
            }
        }
        throw new FileNotFoundException("File not found");
    }
}
