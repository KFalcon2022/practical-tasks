package com.walking.lesson32_files_1.task3.repository;
import com.walking.lesson21_immutable_object.car.Car;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CarRepository {
    public static final String FILE_LOCATION = "./resources/carCatalog.txt";

    public static void saveCars(Car[] cars) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(FILE_LOCATION)) {
            for (Car car : cars) {
                String carInfo = car.toString() + "\n";
                byte[] bytes = carInfo.getBytes();
                fos.write(bytes, 0, bytes.length);
            }
            System.out.println("Файл записан.");

        } catch (IOException ex) {
            throw new RuntimeException("Не удалось записать файл", ex);
        }
    }

    public static Car[] getAll(String[] cars) {
        Car[] carsArr = new Car[cars.length];
        for (int i = 0; i < carsArr.length; i++) {
            String[] info = cars[i].split(",");
            carsArr[i] = new Car(info[0].trim(), info[1].trim(), info[2].trim());
        }
        return carsArr;
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

    public static String[] getCarInformation(String cars) {
        return cars.replaceAll("Машина марки", "")
                .replaceAll("владелец:", "")
                .replaceAll("номер:", "")
                .split("\n");
    }
}
