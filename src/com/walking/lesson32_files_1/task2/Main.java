package com.walking.lesson32_files_1.task2;

import com.walking.lesson19_object_methods.car.Car;

import java.io.FileReader;
import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(readFile("./resources/carCatalog.txt"));
        Car[] cars = getCars(readFile("./resources/carCatalog.txt"));
        System.out.println(cars[0].getBrand());
        System.out.println(cars[0].getOwner());
        System.out.println(cars[0].getNumber());
    }

    public static String readFile(String nameFile) throws IOException {
        StringBuilder cars = new StringBuilder("");
        int i;
        try (FileReader reader = new FileReader(nameFile)) {
                while ((i = reader.read()) != -1) {
                    cars.append((char) i);
                }
            }
        return cars.toString().trim();
    }

    public static Car[] getCars(String cars) {
        String[] carInformation = cars.split("\n");
        Car[] carsArr = new Car[carInformation.length];
        for(int i = 0; i < carsArr.length; i++) {
            String information = carInformation[i].replaceAll(",", "");
            String[] car = information.split(" ");
            carsArr[i] = new Car(car[2], car[4] + " " + car[5], car[7]);
        }
        return carsArr;
    }
}
