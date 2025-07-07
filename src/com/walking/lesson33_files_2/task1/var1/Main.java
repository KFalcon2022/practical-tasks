package com.walking.lesson33_files_2.task1.var1;

import com.walking.lesson33_files_2.model.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Реализуйте Задачу 1 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileWriter;
 */

public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33_files_2/task1/var1/carCatalog.txt";

    public static void main(String[] args) {
        File file = new File(CAR_CATALOG_FILE_PATH);
        Car[] cars = initCars();
        try {
            if (file.createNewFile()) {
                writeCarCatalog(file, cars);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeCarCatalog(File carCatalogFile, Car[] cars) {

        try (FileWriter writer = new FileWriter(carCatalogFile)) {
            if (carCatalogFile.isFile()) {
                System.out.println("Record started");
                StringBuilder carCatalogText = new StringBuilder();

                for (Car car : cars) {
                    carCatalogText.append(parseString(car));
                    carCatalogText.append('\n');
                }

                writer.write(carCatalogText.toString());
                System.out.println("Record completed");
            }
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
