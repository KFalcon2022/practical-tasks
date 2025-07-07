package com.walking.lesson33_files_2.task2.var2;

import com.walking.lesson33_files_2.model.Car;

import java.io.*;

/**
 * Реализуйте Задачу 2 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 2: BufferedInputStream;
 */
public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33_files_2/task2/var2/carCatalog.txt";

    public static void main(String[] args) {
        File carCatalogFile = new File(CAR_CATALOG_FILE_PATH);
        String carCatalogText = readCarCatalog(carCatalogFile);
        Car[] cars = getCars(carCatalogText.split("\n"));

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static String readCarCatalog(File carCatalogFile) {
        StringBuilder carCatalogText = new StringBuilder();

        if (carCatalogFile.isFile()) {
            try (FileInputStream fileInputStream = new FileInputStream(carCatalogFile);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
                byte[] byteCarCatalog = bufferedInputStream.readAllBytes();

                for (byte b : byteCarCatalog) {
                    carCatalogText.append((char) b);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return carCatalogText.toString();
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
