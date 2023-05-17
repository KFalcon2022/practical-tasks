package com.walking.lesson20_exceptions.task1_catchException.model;
import java.io.FileNotFoundException;
public class FileService {
    public File searchFileByName(File[] files, String name) throws FileNotFoundException {
        for (File file : files){
            if (file.getName().equals(name)){
                return file;
            }
        }

        throw new FileNotFoundException();
    }
}
