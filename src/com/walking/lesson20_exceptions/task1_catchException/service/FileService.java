package com.walking.lesson20_exceptions.task1_catchException.service;

import com.walking.lesson20_exceptions.task1_catchException.model.File;

import java.io.FileNotFoundException;

public class FileService {

    public String searchFile(File[] files, String searchingFile) throws FileNotFoundException {

        for (File file : files) {
            if (file.getName().equals(searchingFile)) {
                return file.toString();
            }
        }
        throw new FileNotFoundException();
    }
}
