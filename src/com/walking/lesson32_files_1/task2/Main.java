package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task2.parser.CarParser;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) {

        String carsString = readCars("./carCatalog.txt");

        CarParser carParser = new CarParser();
        Car[] cars = carParser.parseToCar(carsString);

        for (Car car : cars) {
            if (car != null) {
                System.out.println(car);
            }
        }
    }

    static String readCars(String path) {
        StringBuilder cars = new StringBuilder();

        try (FileInputStream inputStream = new FileInputStream(path)) {
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
