package com.walking.lesson32_files_1.task2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        try (FileInputStream fin = new FileInputStream("./resource/carCatalog.txt")) {

            int i;
            while ((i = fin.read()) != -1) {

                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
