package com.walking.lesson33_files_2.task2;

import com.walking.lesson33_files_2.task2.Variants.MyBufferedInputStream;
import com.walking.lesson33_files_2.task2.Variants.MyBufferedReader;
import com.walking.lesson33_files_2.task2.Variants.MyFileReader;

import java.io.File;

/**
 * Реализуйте Задачу 2 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileReader;
 * Вариант 2: BufferedInputStream;
 * Вариант 3: BufferedReader.
 */
public class Main {

    public static final File catalog = new File("./resource/carCatalog.txt");

    public static void main(String[] args) {
        MyBufferedReader reader = new MyBufferedReader();
        reader.readInformation();
    }
}
