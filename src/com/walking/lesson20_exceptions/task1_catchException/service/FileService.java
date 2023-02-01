package com.walking.lesson20_exceptions.task1_catchException.service;

import com.walking.lesson20_exceptions.task1_throwsException.model.DataType;
import com.walking.lesson20_exceptions.task1_throwsException.model.File;

import java.io.FileNotFoundException;

public class FileService {

    public File findFile(String fileName) throws FileNotFoundException {
        for (File file : getFiles()) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }

        throw new FileNotFoundException();
    }

    private File[] getFiles() {
        return new File[]{
                new File("1.txt", 10, DataType.TEXT),
                new File("file_text.txt", 10, DataType.TEXT),
                new File("2.mp3", 20, DataType.AUDIO),
                new File("file_audio.mp3", 20, DataType.AUDIO),
                new File("3.mpg", 30, DataType.VIDEO),
                new File("file_video.mpg", 30, DataType.VIDEO),
        };
    }
}
