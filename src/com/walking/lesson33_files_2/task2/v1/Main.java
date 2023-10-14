package com.walking.lesson33_files_2.task2.v1;

import com.walking.lesson33_files_2.model.Car;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

//FireReader

public class Main {
    private final static String CATALOG_PATH = "./resource/files/lesson32/carCatalog_33_lesson.txt";

    public static void main(String[] args) throws IOException {
        Car[] cars = getCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Car[] getCars() {
        try (FileReader reader = new FileReader(CATALOG_PATH)) {
            StringBuilder stringBuilder = new StringBuilder();

            int i;
            while((i = reader.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String[] carsStringArray = getCarsStringArray(stringBuilder.toString());

            Car[] cars = new Car[carsStringArray.length];
            for (int j = 0; j < carsStringArray.length; j++) {
                cars[j] = parseCar(carsStringArray[j]);
            }

            return cars;

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла.");
        }
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
