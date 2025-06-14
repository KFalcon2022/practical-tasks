package com.walking.lesson32_files_1.task2;

import com.walking.lesson19_object_methods.car.Car;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Car[] cars = getCars(getCarInformation(readFile("./resources/carCatalog.txt")));
        Scanner in = new Scanner(System.in);
        System.out.print("Номер машины в списке: ");
        int i = in.nextInt();

        System.out.println(cars[i - 1].getBrand());
        System.out.println(cars[i - 1].getOwner());
        System.out.println(cars[i - 1].getNumber());
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

    public static Car[] getCars(String[] cars) {
        Pattern number = Pattern.compile("[а-я]{2}\\d{3}[а-я]");
        Pattern owner = Pattern.compile("[А-Я][а-я]+ [А-Я]\\.[А-Я]\\.");
        Car[] carsArr = new Car[cars.length];
        for (int i = 0; i < carsArr.length; i++) {
            Matcher matcher = number.matcher(cars[i]);
            String num = "";
            while (matcher.find()) {
                num = matcher.group();
            }
            matcher = owner.matcher(cars[i]);
            String own = "";
            while (matcher.find()) {
                own = matcher.group();
            }
            String brand = cars[i].replaceAll(num, "")
                    .replaceAll(own, "")
                    .trim();
            carsArr[i] = new Car(brand, own, num);
        }
        return carsArr;
    }

    private static String[] getCarInformation(String cars) {
        String[] carInformation = cars.split("\n");
        for (int i = 0; i < carInformation.length; i++) {
            String car = carInformation[i].replaceAll(",", "")
                    .replaceAll("Машина марки", "")
                    .replaceAll("владелец:", "")
                    .replaceAll("номер:", "")
                    .trim();
            carInformation[i] = car;
        }
        return carInformation;
    }
}
