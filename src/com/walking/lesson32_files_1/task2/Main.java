package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {

    public static final String CAR_CATALOG_TXT_DIRECTORY = "./resource/files/lesson32_files_1/task2/carCatalog.txt";

    public static void main(String[] args) {
        String carCatalog = readCarCatalog();
        String[] carsArray = carCatalog.split("\n");
        Car[] cars = new Car[carsArray.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = parseCar(carsArray[i].split(";"));
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }


    private static String readCarCatalog() {
        StringBuilder fileLine = new StringBuilder();
        try (FileInputStream carCatalogueReader = new FileInputStream(CAR_CATALOG_TXT_DIRECTORY)) {
            int i;

            while ((i = carCatalogueReader.read()) != -1) {
                fileLine.append((char) i);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileLine.toString();
    }

    private static Car parseCar(String[] carInformation) {
        String number = carInformation[0];
        int year = Integer.parseInt(carInformation[1]);
        String color = carInformation[2];

        return new Car(number, year, color);
    }
}
