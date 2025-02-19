package com.walking.lesson20_exceptions.task1_throwsException;

import java.io.FileNotFoundException;

public class FileService {
    File[] files;

    public FileService(File[] files) {
        this.files = files;
    }


    public File findFile(String s) throws FileNotFoundException {

        for (File file : files) {
            if (file.getName().equals(s)) {
                return file;
            }

        }
        throw new FileNotFoundException();
    }
}
