package com.walking.lesson33_files_2.task2.var1;

import com.walking.lesson33_files_2.model.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Реализуйте Задачу 2 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileReader;
 */

public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33_files_2/task2/var1/carCatalog.txt";

    public static void main(String[] args) {
        File carCatalogFile = new File(CAR_CATALOG_FILE_PATH);
        String carCatalogText = readCarCatalog(carCatalogFile);
        Car[] cars = getCars(carCatalogText.split("\n"));

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static String readCarCatalog(File carCatalogFile)  {
        StringBuilder carCatalogText = new StringBuilder();
        if (carCatalogFile.isFile()) {
            int i;
            try (FileReader reader = new FileReader(carCatalogFile)) {
                while ((i = reader.read()) != -1) {
                    carCatalogText.append((char) i);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return carCatalogText.toString();
    }

    private static Car[] getCars(String[] catCatalogText) {
        Car[] cars = new Car[catCatalogText.length];

        for (int i = 0; i < catCatalogText.length; i++) {
            cars[i] = parseCar(catCatalogText[i].split(";"));
        }

        return cars;
    }

    private static Car parseCar(String[] carText) {
        String number = carText[0];
        int year = Integer.parseInt(carText[1]);
        String color = carText[2];
        return new Car(number, year, color);
    }
}
