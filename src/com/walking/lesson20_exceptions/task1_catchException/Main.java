package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.files.FileClass;
import com.walking.lesson20_exceptions.task1_catchException.files.FileTypes;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileClass[] files = new FileClass[]{new FileClass("Movie", 7356, FileTypes.VIDEO),
                                            new FileClass("Song", 12, FileTypes.AUDIO),
                                            new FileClass("Document", 4, FileTypes.TEXT),
                                            new FileClass("Picture", 15, FileTypes.IMAGE)};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name:");
        String name = scanner.next();
        scanner.close();

        System.out.println(findFile(files, name).toString());

    }

    private static FileClass findFile(FileClass[] files, String name) {
        try {
            for (FileClass file : files) {
                if (name.equals(file.getName())) {
                    return file;
                } else throw new FileNotFoundException("File does not exist.");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return files[0];
    }
}
