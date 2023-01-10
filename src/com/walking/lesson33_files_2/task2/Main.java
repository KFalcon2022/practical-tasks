package com.walking.lesson33_files_2.task2;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task2.parser.CarParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

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
    public static void main(String[] args) {

        File carCatalog = new File("./", "carCatalog.txt");
        CarParser carParser = new CarParser();
        Car[] cars = carParser.parseToCar(readCars(carCatalog));

        for (Car car : cars) {
            if (car != null) {
                System.out.println(car);
            }
        }
    }

    static String readCars(File file) {
        StringBuilder cars = new StringBuilder();

        try (FileInputStream inputStream = new FileInputStream(file)) {
            int in;
            while ((in = inputStream.read()) != -1) {
                cars.append((char) in);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return cars.toString();
    }
}
