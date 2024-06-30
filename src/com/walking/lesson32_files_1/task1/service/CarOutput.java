package com.walking.lesson32_files_1.task1.service;

import com.walking.lesson32_files_1.task1.model.Car;
import java.io.FileOutputStream;
import java.io.IOException;

public class CarOutput {
    private final Car[] cars;

    public CarOutput(Car[] cars) {
        this.cars = cars;
    }

    public void createCarCatalog() {
        System.out.println("Старт записи.");

        try (FileOutputStream fos = new FileOutputStream("carCatalog.txt")) {
            for (Car car : cars) {
                fos.write(mapCarToFileView(car).getBytes());
                fos.write('\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Запись окончена.");
    }

    private static String mapCarToFileView(Car car) {
        return "%s;%s;%s;%s".formatted(
                car.getModel(), car.getNumber(), car.getYear(), car.getColor());
    }
}
