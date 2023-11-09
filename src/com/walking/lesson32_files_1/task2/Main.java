package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {

    static final String PATH = "./resource/carCatalog.txt";

    public static void main(String[] args) {
        Car[] cars = readFileCarCatalog();

        System.out.println(cars.length);
    }

    public static Car [] readFileCarCatalog() {
        try (FileInputStream fin = new FileInputStream(PATH)) {

            String stringCarCatalog = new String(fin.readAllBytes());
            String[] stringArrayCarCatalog = stringCarCatalog.split("\n");

            Car[] cars = new Car[stringArrayCarCatalog.length];
            int i = 0;

            for (String stringCar : stringArrayCarCatalog) {

                cars[i++] = new Car(stringCar.split("\\|"));
            }

            return cars;

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        return null;
    }
}
