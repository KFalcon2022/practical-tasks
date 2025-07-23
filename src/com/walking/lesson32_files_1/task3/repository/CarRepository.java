package com.walking.lesson32_files_1.task3.repository;

import com.walking.lesson21_immutable_object.car.Car;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CarRepository {
    public static final String FILE_LOCATION = "./resources/carCatalog.txt";
    public Car[] carsArr;

    public void saveAll(Car[] cars) {
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

    public void findAll() throws IOException {
        String[] carsInfo = readFile().split("\n");
        Car[] carsArr = new Car[carsInfo.length];

        for (int i = 0; i < carsArr.length; i++) {
            carsArr[i] = getCar(carsInfo[i]);
        }
        this.carsArr = carsArr;
    }

    private String readFile() throws IOException {
        StringBuilder cars = new StringBuilder();
        try (FileReader reader = new FileReader(FILE_LOCATION)) {
            int i;
            while ((i = reader.read()) != -1) {
                cars.append((char) i);
            }
        }
        return cars.toString().trim();
    }

    private Car getCar(String car) {
        String[] info = car.split(",");
        String brand = info[0] == null ? null : info[0].trim();
        String owner = info[1] == null ? null : info[1].trim();
        String number = info[2] == null ? null : info[2].trim();
        return new Car(brand, owner, number);
    }
}
