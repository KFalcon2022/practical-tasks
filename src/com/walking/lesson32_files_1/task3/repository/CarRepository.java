package com.walking.lesson32_files_1.task3.repository;

import com.walking.lesson21_immutable_object.car.Car;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CarRepository {
    public static final String FILE_LOCATION = "./resources/carCatalog.txt";
    private Car[] carsArr;

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
        Car[] arr = new Car[carsInfo.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = getCar(carsInfo[i]);
        }
        this.carsArr = arr;
    }

    public Car[] deleteCar(int index) {
        int length = carsArr.length;
        Car[] updatedCars = new Car[length - 1];
        for (int i = 0; i < length; i++) {
            if (i < index) {
                updatedCars[i] = carsArr[i];
            }

            if (i > index) {
                updatedCars[i - 1] = carsArr[i];
            }
        }
        return updatedCars;
    }

    /** ты только про удаление написал, но я подумала, будет логично по аналогии сделать метод и с добавлением машины.
     * если, конечно, я правильно поняла, какую логику сюда перенести надо было ахаха
     */
    public Car[] addCar(Car car) {
        int length = carsArr.length;
        Car[] updatedCars = Arrays.copyOf(carsArr, length + 1);
        updatedCars[length] = car;
        return updatedCars;
    }

    public Car[] getCarsArr() {
        return Arrays.copyOf(carsArr, carsArr.length);
    }

    public void setCarsArr(Car[] carsArr) {
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
