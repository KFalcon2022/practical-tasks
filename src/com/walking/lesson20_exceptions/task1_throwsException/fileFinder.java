package Lesson20.Task1;

import java.io.FileNotFoundException;
import java.util.*;

public class fileFinder {
    List <Files> filesList = new ArrayList<>();

    public fileFinder(ArrayList<Files> files)
    {
        this.filesList.addAll(files);
    }
    public Files findFile(String name) throws FileNotFoundException {
        for (Files file : filesList)
        {
            if (file.fileName.contains(name))
                return file;
        }
        throw new FileNotFoundException("File not found");
    }
}
