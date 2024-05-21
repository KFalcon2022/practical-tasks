package com.walking.lesson33_files_2.task2.Variants;

import com.walking.lesson33_files_2.task2.Main;

import java.io.FileReader;
import java.io.IOException;

public class MyFileReader implements ReaderInterface {


    @Override
    public void readInformation() {
        try (FileReader reader = new FileReader(Main.catalog)){

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (IOException exception) {

            System.out.println(exception.getMessage());
        }
    }
}
