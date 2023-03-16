package com.walking.lesson20_exceptions.task1_catchException;

import java.io.FileNotFoundException;

public class FileService {
    File [] files;

    FileService(File ...files){
        this.files = new File[files.length];
        System.arraycopy(files, 0, this.files, 0, files.length);
    }

    public String findFile(String name, FileType type){

        for (File f:files) {
            if (f.equals(new File(name,type))){
                return f.toString();
            }
        }
        return "Искомый файл не существует";
    }

    public String findFileWithException(String name, FileType type) throws FileNotFoundException {

        for (File f:files) {
            if (f.equals(new File(name,type))){
                return f.toString();
            }
        }
        throw new FileNotFoundException("Искомый файл не существует");
    }

}
