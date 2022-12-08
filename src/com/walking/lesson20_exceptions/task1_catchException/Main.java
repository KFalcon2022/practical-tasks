package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.file.FileClass;
import com.walking.lesson20_exceptions.task1_catchException.file.FileTypes;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileClass[] files = new FileClass[]{new FileClass("Movie", 7356, FileTypes.VIDEO),
                                            new FileClass("Song", 12, FileTypes.AUDIO),
                                            new FileClass("Document", 4, FileTypes.TEXT),
                                            new FileClass("Picture", 15, FileTypes.IMAGE)};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name:");
        String name = scanner.next();
        scanner.close();

        System.out.println(findFile(files, name));
    }

    private static FileClass findFile(FileClass[] files, String name) throws FileNotFoundException {
        for (FileClass file : files) {
            if (name.equals(file.getName())) {
                return file;
            }
        }

        throw new FileNotFoundException("File does not exist.");
    }
}
