package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {

    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson32_files_1/task2/carCatalog.txt";

    public static void main(String[] args) {
        String carCatalog = readCarCatalog(CAR_CATALOG_FILE_PATH);
        Car[] cars = getCars(carCatalog.split("\n"));

        for (Car car : cars) {
            System.out.println(car);
        }
    }


    private static String readCarCatalog(String carCatalogPath) {
        StringBuilder fileLine = new StringBuilder();
        try (FileInputStream carCatalogueReader = new FileInputStream(carCatalogPath)) {
            byte[] b = carCatalogueReader.readAllBytes();

            for (byte sym : b) {
                fileLine.append((char) sym);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileLine.toString();
    }

    private static Car[] getCars(String[] carCatalogText) {
        Car[] cars = new Car[carCatalogText.length];

        for (int i = 0; i < carCatalogText.length; i++) {
            cars[i] = parseCar(carCatalogText[i].split(";"));
        }

        return cars;
    }

    private static Car parseCar(String[] carInformation) {
        String number = carInformation[0];
        int year = Integer.parseInt(carInformation[1]);
        String color = carInformation[2];

        return new Car(number, year, color);
    }
}
