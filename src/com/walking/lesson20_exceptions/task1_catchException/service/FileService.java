package com.walking.lesson20_exceptions.task1_catchException.service;

import com.walking.lesson20_exceptions.task1_catchException.model.File;

import java.io.FileNotFoundException;

public class FileService {
    private File[] files;

    public FileService(File[] files) {
        this.files = files;
    }

    public File[] getFiles() {
        return files;
    }

    public File findFileByName(String name) throws FileNotFoundException {
        for (File file : files) {
            if(file.getName().equals(name)) {
                return file;
            }
        }

        throw new FileNotFoundException("Искомый файл '" + name + "' не существует");
    }
}
