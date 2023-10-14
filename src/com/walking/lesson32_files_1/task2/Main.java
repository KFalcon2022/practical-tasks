package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task2.model.Car;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    private final static String CATALOG_PATH = "./resource/files/lesson32/carCatalog.txt";

    public static void main(String[] args) throws IOException {
        Car[] cars = getCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Car[] getCars() {
        try (FileInputStream fis = new FileInputStream(CATALOG_PATH)) {
            StringBuilder stringBuilder = new StringBuilder();

            int i;
            while((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String[] carsStringArray = getCarsStringArray(stringBuilder.toString());

            Car[] cars = new Car[carsStringArray.length];
            for (int j = 0; j < carsStringArray.length; j++) {
                cars[j] = parseCar(carsStringArray[j]);
            }

            return cars;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static String[] getCarsStringArray(String cars) {
        String[] carsStringArray = cars.split("\n");
        return carsStringArray;
    }

    private static Car parseCar(String stringCar) {
        String[] car = stringCar.split(";");

        String mark = car[0];
        String color = car[1];
        int yearManufacture = Integer.parseInt(car[2]);
        int stateNumber = Integer.parseInt(car[3]);

        return new Car(mark, color, yearManufacture, stateNumber);
    }
}
