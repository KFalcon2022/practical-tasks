package com.walking.lesson20_exceptions.task1_throwsException.service;

import com.walking.lesson20_exceptions.task1_throwsException.model.File;

public class FileService {
    private File[] files;

    public FileService(File[] files) {
        this.files = files;
    }

    public File search(String userFile) throws FileNotFoundException {
        for (File file : files) {
            if (userFile.equals(file.getFileName())) {
                return file;
            }
        }
        throw new FileNotFoundException("Искомый файл не найден");
    }
}
