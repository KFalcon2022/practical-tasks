package com.walking.lesson32_files_1.task3.repository;

import com.walking.lesson32_files_1.task3.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CarRepository {
    private static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson32_files_1/task3/carCatalog.txt";

    public Car[] getCarCatalog() {
        String carCatalog = readCarCatalog();
        String[] carsArray = carCatalog.split("\n");
        Car[] cars = new Car[carsArray.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = parseCar(carsArray[i]);
        }

        return cars.clone();
    }

    public void writeCarCatalog(Car[] cars) {
        try (FileOutputStream carCatalog = new FileOutputStream(CAR_CATALOG_FILE_PATH, false)) {
            for (Car car : cars) {
                byte[] bytesCarInformation = car.toString().getBytes();

                carCatalog.write(bytesCarInformation);
                carCatalog.write("\n".getBytes());
            }

            System.out.println("Recording is over");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readCarCatalog() {
        try (FileInputStream fileInputStream = new FileInputStream(CAR_CATALOG_FILE_PATH)) {
            return new String(fileInputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Car parseCar(String carStr) {
        String[] splitCarStr = carStr.split(";");

        String number = splitCarStr[0].equals("null") ? null : splitCarStr[0];
        int year = Integer.parseInt(splitCarStr[1]);
        String color = splitCarStr[2].equals("null") ? null : splitCarStr[2];

        return new Car(number, year, color);

    }
}
