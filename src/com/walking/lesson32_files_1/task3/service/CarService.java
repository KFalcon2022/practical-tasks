package com.walking.lesson32_files_1.task3.service;

import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.repository.CarRepository;

import java.io.File;

public class CarService {
    private final CarRepository carRepository;

    public CarService(File repositorySource) {
        if (repositorySource == null) {
            throw new NullPointerException("Need not null File value");
        }

        this.carRepository = new CarRepository(repositorySource);
    }

    public Car[] getCars() {
        return carRepository.getCars();
    }

    public boolean add(Car car) {
        if (car == null || contains(car)) {
            return false;
        }

        carRepository.setCars(getArrayWith(car));

        carRepository.save();

        return true;
    }

    public boolean remove(Car car) {
        int foundCarIndex = indexOf(car);

        if (foundCarIndex != -1) {
            carRepository.setCars(getArrayWithout(foundCarIndex));

            carRepository.save();

            return true;
        }

        return false;
    }

    public Car find(Car car) {
        if (car == null) {
            throw new NullPointerException("Need not null Car value");
        }

        int foundCarIndex = indexOf(car);

        /* null допустимо возвращать как отрицательный результат поиска объекта? */
        if (foundCarIndex == -1) {
            return null;
        }

        return carRepository.getCars()[foundCarIndex];
    }

    public void update() {
        carRepository.save();
    }

    public void displayCars() {
        System.out.println("-".repeat(56));

        for (Car car : carRepository.getCars()) {
            System.out.println(car);
        }

        System.out.println();
    }

    private int indexOf(Car car) {
        if (car == null) {
            return -1;
        }

        Car[] cars = carRepository.getCars();

        for (int i = 0; i < cars.length; i++) {
            if (car.equals(cars[i])) {
                return i;
            }
        }

        return -1;
    }

    private boolean contains(Car car) {
        return indexOf(car) >= 0;
    }

    private Car[] getArrayWith(Car car) {
        Car[] startCars = carRepository.getCars();
        Car[] endCars = new Car[startCars.length + 1];

        for (int i = 0; i < startCars.length; i++) {
            endCars[i] = startCars[i];
        }

        endCars[endCars.length - 1] = car;

        return endCars;
    }

    private Car[] getArrayWithout(int carIndex) {
        Car[] startCars = carRepository.getCars();
        Car[] endCars = new Car[startCars.length - 1];

        for (int i = 0; i < carIndex; i++) {
            endCars[i] = startCars[i];
        }

        for (int i = carIndex; i < endCars.length; i++) {
            endCars[i] = startCars[i + 1];
        }

        return endCars;
    }
}
