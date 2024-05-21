package com.walking.lesson33_files_2.task2.Variants;

import com.walking.lesson33_files_2.task2.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReader implements ReaderInterface {

    @Override
    public void readInformation() {

        try (BufferedReader reader = new BufferedReader(new FileReader(Main.catalog))) {

            String s;
            while ((s = reader.readLine()) != null) {

                System.out.println(s);
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }
}
