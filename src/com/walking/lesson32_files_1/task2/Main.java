package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task2.parser.CarParser;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) {

        Car[] cars = readCarsFrom("./carCatalog.txt");

        for (Car car : cars) {
            if (car!=null) {
                System.out.println(car);
            }
        }
    }

    static Car[] readCarsFrom(String path) {
        Car [] cars = new Car[10];
        try (FileInputStream inputStream = new FileInputStream(path)) {
            int in;
            int i = 0;
            StringBuilder car = new StringBuilder();
            while ((in = inputStream.read()) != -1) {
                if (in != '\n') {
                    car.append((char)in);
                } else {
                    cars[i] = CarParser.parseToCar(car.toString());
                    i++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return cars;
    }
}
