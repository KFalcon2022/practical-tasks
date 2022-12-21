package com.walking.lesson32_files_1.task3.repository;

import com.walking.lesson32_files_1.task3.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CarRepository {
    private static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson32/task3/carCatalog.txt";

    public Car[] findAll() {
        String carsStr = readFile().trim();
        String[] carStrArray = carsStr.split("\n");

        Car[] cars = new Car[carStrArray.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = parseCar(carStrArray[i]);
        }

        return cars;
    }

    public void saveAll(Car[] cars) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CAR_CATALOG_FILE_PATH)) {
            for (Car car : cars) {
                fileOutputStream.write(mapCarToFileView(car).getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error of file writing", e);
        }
    }

    private String readFile() {
        try (FileInputStream fileInputStream = new FileInputStream(CAR_CATALOG_FILE_PATH)) {
            return new String(fileInputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error of file reading", e);
        }
    }

    private Car parseCar(String carStr) {
        String[] splitCarStr = carStr.split(";");

        String number = splitCarStr[0].equals("null") ? null : splitCarStr[0];
        int year = Integer.parseInt(splitCarStr[1]);
        String color = splitCarStr[2].equals("null") ? null : splitCarStr[2];
        boolean actualTechnicalInspection = splitCarStr[3].equals("true");

        return new Car(number, year, color, actualTechnicalInspection);
    }

    private String mapCarToFileView(Car car) {
        return "%s;%d;%s;%s\n".formatted(
                car.getNumber(), car.getYear(), car.getColor(), car.isActualTechnicalInspection());
    }
}
