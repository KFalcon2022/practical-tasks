package com.walking.lesson33_files_2.task2.v3;

import com.walking.lesson33_files_2.model.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//BufferedReader

public class Main {
    private final static String CATALOG_PATH = "./resource/files/lesson32/carCatalog_33_lesson.txt";

    public static void main(String[] args) throws IOException {
        File carCatalog = new File(CATALOG_PATH);

        Car[] cars = getCars(carCatalog);
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Car[] getCars(File carCatalog) {
        try (FileReader fr = new FileReader(carCatalog);
             BufferedReader reader = new BufferedReader(fr)) {

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
