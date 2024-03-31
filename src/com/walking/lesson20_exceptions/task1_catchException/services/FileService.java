package com.walking.lesson20_exceptions.task1_catchException.services;

import com.walking.lesson20_exceptions.task1_catchException.models.File;

import java.io.FileNotFoundException;

public class FileService{
    private File[] files;
    public FileService(File[] files){
        this.files=files;
    }
    public void findFile(String name) throws FileNotFoundException {
        boolean searchResultFlag=false;
            for (File file : files) {
                if (file.getName().equals(name)) {
                    displayFile(file);
                    searchResultFlag=true;
                }
            }
            if (!searchResultFlag) {
                throw new FileNotFoundException("\nThe file you are looking for doesn't exist...");
            }

    }
    private void displayFile(File file){
        System.out.println("\nYour file was found.");
        System.out.println(file);
    }
}