package com.walking.lesson20_exceptions.task1_throwsException.services;

import com.walking.lesson20_exceptions.task1_throwsException.models.File;

import java.io.FileNotFoundException;

public class FileService {
    private File[] files;

    public FileService(File[] files) {
        this.files = files;
    }

    public void findFile(String name) throws FileNotFoundException {
        boolean isSearchSuccess = false;
        for (File file : files) {
            if (file.getName().equals(name)) {
                displayFile(file);
                isSearchSuccess = true;
            }
        }
        if (!isSearchSuccess) {
            throw new FileNotFoundException("The file you are looking for doen't exist");
        }
    }

    private void displayFile(File file) {
        System.out.println("\nYour file was found.");
        System.out.println(file);
    }
}
