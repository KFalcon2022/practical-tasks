package com.walking.lesson32_files_1.task2;

import com.walking.lesson19_object_methods.car.Car;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static final String FILE_LOCATION = "./resources/carCatalog.txt";

    public static void main(String[] args) throws IOException {
        String text = readFile();
        Car[] cars = getCars(getCarInformation(text));
        Scanner in = new Scanner(System.in);
        System.out.print("Номер машины в списке: ");
        int i = in.nextInt();

        System.out.println(cars[i - 1].getBrand());
        System.out.println(cars[i - 1].getOwner());
        System.out.println(cars[i - 1].getNumber());
    }

    public static String readFile() throws IOException {
        StringBuilder cars = new StringBuilder();
        try (FileReader reader = new FileReader(FILE_LOCATION)) {
            int i;
            while ((i = reader.read()) != -1) {
                cars.append((char) i);
            }
        }
        return cars.toString().trim();
    }

    public static Car[] getCars(String[] cars) {
        Car[] carsArr = new Car[cars.length];
        for (int i = 0; i < carsArr.length; i++) {
            String[] info = cars[i].split(",");
            carsArr[i] = new Car(info[0].trim(), info[1].trim(), info[2].trim());
        }
        return carsArr;
    }

    private static String[] getCarInformation(String cars) {
        return cars.replaceAll("Машина марки", "")
                .replaceAll("владелец:", "")
                .replaceAll("номер:", "")
                .split("\n");
    }
}
