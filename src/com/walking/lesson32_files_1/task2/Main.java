package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task2.model.Car;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson32/task2/carCatalog.txt";

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

        StringBuilder carsStr = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(CAR_CATALOG_FILE_PATH)) {
//            Чтение можно обеспечить и проще через вызов readAllBytes()
            boolean isInputFinished = false;

            while (!isInputFinished) {
                int symbol = fileInputStream.read();

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
