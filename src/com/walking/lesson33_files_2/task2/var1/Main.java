package com.walking.lesson33_files_2.task2.var1;

import com.walking.lesson33_files_2.model.Car;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Реализуйте Задачу 2 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью FileReader.
 */
public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33/task2/carCatalog.txt";

    public static void main(String[] args) {
        String carsStr = readCarCatalog();
        String[] carStrArray = carsStr.split("\n");

        Car[] cars = new Car[carStrArray.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = parseCar(carStrArray[i]);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static String readCarCatalog() {
        System.out.println("File reading started");

        File carCatalogFile = new File(CAR_CATALOG_FILE_PATH);
        StringBuilder carsStr = new StringBuilder();
        try (FileReader fileReader = new FileReader(carCatalogFile)) {
            boolean isInputFinished = false;

            while (!isInputFinished) {
                int symbol = fileReader.read();

                if (symbol == -1) {
                    isInputFinished = true;
                } else {
                    carsStr.append((char) symbol);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error of file reading", e);
        }

        System.out.println("File reading finished");

        return carsStr.toString();
    }

    private static Car parseCar(String carStr) {
        String[] splitCarStr = carStr.split(";");

        String number = splitCarStr[0].equals("null") ? null : splitCarStr[0];
        int year = Integer.parseInt(splitCarStr[1]);
        String color = splitCarStr[2].equals("null") ? null : splitCarStr[2];
        boolean actualTechnicalInspection = splitCarStr[3].equals("true");

        return new Car(number, year, color, actualTechnicalInspection);
    }
}
