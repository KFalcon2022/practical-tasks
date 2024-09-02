package com.walking.lesson61_synchronized.repository;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRepository {
    private static final String CAR_CATALOG_FILE_PATH = "./practical-tasks/resource/lesson33/carCatalog.txt";

    public List<Car> findAll() {
        String carsStr = readFile().trim();
        String[] carStrArray = carsStr.split("\n");

        List<Car> cars = new ArrayList<>(carStrArray.length);

        for (String carStr : carStrArray) {
            cars.add(parseCar(carStr));
        }

        return cars;
    }

    public synchronized void saveAll(List<Car> cars) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CAR_CATALOG_FILE_PATH)) {
            for (Car car : cars) {
                fileOutputStream.write(mapCarToFileView(car).getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error of file writing", e);
        }
    }

    private synchronized String readFile() {
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
        Color color = splitCarStr[2].equals("null") ? null : Color.parseColorByName(splitCarStr[2]);
        boolean hasFine = splitCarStr[3].equals("true");

        return new Car(number, year, color, hasFine);
    }

    private String mapCarToFileView(Car car) {
        return "%s;%d;%s;%s\n".formatted(car.getNumber(), car.getYear(), car.getColor().getName(), car.hasFine());
    }
}

