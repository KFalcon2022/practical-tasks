package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task1.model.Color;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) {
        String carsStr = carsRead();
        String[] carsArr = carsStr.split("\n");

        Car[] cars = new Car[carsArr.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = parseCar(carsArr[i]);
        }


    }


    private static Car parseCar(String s) {
        String [] carStr = s.split(";");

        String model = carStr[0];
        String number = carStr[1];
        int year = Integer.parseInt(carStr[2]);
        Color color = Color.valueOf(carStr[3]);

        return new Car(model, number, year, color);
    }

    private static String carsRead() {
        StringBuilder line = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream("carCatalog.txt")) {
            int i = 0;

            while ((i = fileInputStream.read()) != -1) {
                line.append((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return line.toString();
    }
}
