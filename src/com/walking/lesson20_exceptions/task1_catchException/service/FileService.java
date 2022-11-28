package com.walking.lesson20_exceptions.task1_catchException.service;

import com.walking.lesson20_exceptions.task1_catchException.model.File;

import java.io.FileNotFoundException;

public class FileService {
    private final File[] files;

    public FileService(File[] files) {
        this.files = files;
    }

    public File findFile(String name) throws FileNotFoundException {
        for (File f : files) {
            if (f.getName().equals(name)) {
                return f;
            }
        }

        throw new FileNotFoundException("File not found");
//        Обратите внимание: после выбрасывания исключения не нужен return
    }
}
