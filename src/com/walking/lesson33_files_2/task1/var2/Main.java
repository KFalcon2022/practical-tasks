package com.walking.lesson33_files_2.task1.var2;

import com.walking.lesson33_files_2.model.Car;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Реализуйте Задачу 1 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью BufferedOutputStream.
 */
public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33/task1/carCatalog.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();

        System.out.println("File writing started");

        File carCatalogFile = new File(CAR_CATALOG_FILE_PATH);

        try (FileOutputStream fileOutputStream = new FileOutputStream(carCatalogFile);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {

            for (Car car : cars) {
//                Обратите внимание, здесь немного отличается реализация mapCarToFileView() -
//                внутри добавляется '\n'
                byte[] buffer = mapCarToFileView(car).getBytes();

                bufferedOutputStream.write(buffer, 0, buffer.length);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error of file writing", e);
        }

        System.out.println("File writing finished");
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, null, true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }

    private static String mapCarToFileView(Car car) {
        return "%s;%d;%s;%s\n".formatted(
                car.getNumber(), car.getYear(), car.getColor(), car.isActualTechnicalInspection());
    }
}
