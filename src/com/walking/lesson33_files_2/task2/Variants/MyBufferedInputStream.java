package com.walking.lesson33_files_2.task2.Variants;

import com.walking.lesson33_files_2.task2.Main;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyBufferedInputStream implements ReaderInterface {


    @Override
    public void readInformation() {

        try (FileInputStream fileInputStream = new FileInputStream(Main.catalog);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {

            int c;
            while ((c = bufferedInputStream.read()) != -1) {

                System.out.print((char) c);
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
