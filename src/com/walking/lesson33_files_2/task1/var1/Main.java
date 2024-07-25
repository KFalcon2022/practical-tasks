package com.walking.lesson33_files_2.task1.var1;

import com.walking.lesson33_files_2.model.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./src/com/walking/lesson33_files_2/task1/carCatalog.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();
        File carCatalogFile = new File(CAR_CATALOG_FILE_PATH);

        System.out.println("File writing started");
        try (FileWriter fileWriter = new FileWriter(carCatalogFile)) {
            for (Car car : cars) {
                fileWriter.write(mapCarToFileView(car));
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error of file writing", e);
        }
        System.out.println("File writing finished");
    }

    private static String mapCarToFileView(Car car) {
        return "%s;%s;%d;%s".formatted(
                car.getModel(), car.getNumber(), car.getYear(), car.getColor()
        );
    }

    private static Car[] initCars() {
        Car car1 = new Car("X1", "RR-111-RR", 2014, "red");
        Car car2 = new Car("X2", "RR-222-RR", 2015, "blue");
        Car car3 = new Car("X3", "RR-333-RR", 2016, "red");
        Car car4 = new Car("X4", "RR-444-RR", 2017, "blue");
        Car car5 = new Car("X5", "RR-555-RR", 2018, "red");
        Car car6 = new Car("X6", "RR-666-RR", 2019, "blue");
        Car car7 = new Car("X7", "RR-777-RR", 2020, "red");
        Car car8 = new Car("X8", "RR-888-RR", 2021, "blue");
        Car car9 = new Car("X9", "RR-999-RR", 2022, "red");
        Car car10 = new Car("X10", "RR-000-RR", 2023, "blue");

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
