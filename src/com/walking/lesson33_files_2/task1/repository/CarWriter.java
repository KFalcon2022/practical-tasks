package com.walking.lesson33_files_2.task1.repository;

import com.walking.lesson33_files_2.task1.model.Car;

import java.io.*;
import java.util.StringJoiner;

public interface CarWriter {
    default void write(File destination, Car[] cars) {
        try (BufferedWriter carBufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            for (Car car : cars) {
                carBufferedWriter.write(getRepositoryView(car));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(destination.getPath()), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    default String getRepositoryView(Car car) {
        return new StringJoiner(CarRepository.CAR_FIELD_SEPARATOR, "", CarRepository.CAR_SEPARATOR)
                .add(car.getNumber())
                .add(String.valueOf(car.getYear()))
                .add(car.getColor().getName())
                .add(String.valueOf(car.hasFine()))
                .toString();
    }
}
