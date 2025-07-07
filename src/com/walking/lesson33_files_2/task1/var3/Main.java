package com.walking.lesson33_files_2.task1.var3;

import com.walking.lesson33_files_2.model.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Реализуйте Задачу 1 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 3: BufferedWriter.
 */
public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33_files_2/task1/var3/carCatalog.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();

        writeCarCatalog(cars);
    }

    private static void writeCarCatalog(Car[] cars) {
        System.out.println("Record is beginning");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(CAR_CATALOG_FILE_PATH))) {
            for (Car car : cars) {
                bufferedWriter.write(parseString(car));
                bufferedWriter.write('\n');
            }

            System.out.println("Record is over");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow");
        Car car2 = new Car("RR-222-RR", 2016, "yellow");
        Car car4 = new Car("RR-444-RR", 2018, "yellow");
        Car car5 = new Car("RR-555-RR", 2018, "yellow");
        Car car6 = new Car("RR-666-RR", 2018, "yellow");
        Car car7 = new Car("RR-777-RR", 2018, "yellow");
        Car car3 = new Car("RR-333-RR", 2017, "yellow");
        Car car8 = new Car("RR-888-RR", 2018, "yellow");
        Car car9 = new Car("RR-999-RR", 2018, "yellow");
        Car car10 = new Car("RR-000-RR", 2018, "yellow");

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }

    private static String parseString(Car car) {
        return "%s;%s;%s".formatted(car.getNumber(), car.getYear(), car.getColor());
    }
}
