package com.walking.lesson32_files_1.task3.repository;

import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.service.CarParser;

import java.io.*;
import java.util.StringJoiner;

public class CarRepository {
    private final File repositorySource;
    private Car[] cars;

    public CarRepository(File repositorySource) {
        this.repositorySource = repositorySource;
        cars = load();
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public void save() {
        StringBuilder allCars = new StringBuilder();

        for (Car car : cars) {
            allCars.append(getRepositoryView(car));
        }

        saveBytes(allCars.toString().getBytes());
    }

    public Car[] load() {
        String allCars = new String(loadBytes());
        CarParser parser = new CarParser(allCars);

        return parser.parseAllCars();
    }

    private void saveBytes(byte[] bytes) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(repositorySource)) {
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(repositorySource), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private byte[] loadBytes() {
        try (FileInputStream fileInputStream = new FileInputStream(repositorySource)) {
            return fileInputStream.readAllBytes();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(repositorySource), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private String getRepositoryView(Car car) {
        return new StringJoiner(CarParser.CAR_FIELD_SEPARATOR, "", CarParser.CAR_SEPARATOR)
                .add(car.getNumber())
                .add(String.valueOf(car.getYear()))
                .add(car.getColor().getName())
                .add(String.valueOf(car.hasFine()))
                .toString();
    }
}
