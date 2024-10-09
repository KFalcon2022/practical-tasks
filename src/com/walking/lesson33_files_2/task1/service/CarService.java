package com.walking.lesson33_files_2.task1.service;

import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.repository.CarRepository;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car[] getCars() {
        return carRepository.getCars().clone();
    }

    public boolean add(Car car) {
        if (car == null) {
            return false;
        }

        if (contains(car)) {
            carRepository.rewrite();
        } else {
            carRepository.setCars(getArrayWith(car));

            carRepository.add(car);
        }

        return true;
    }

    public boolean remove(Car car) {
        int foundCarIndex = indexOf(car);

        if (foundCarIndex == -1) {
            return false;
        }

        carRepository.setCars(getArrayWithout(foundCarIndex));

        carRepository.rewrite();

        return true;
    }

    public Car find(Car car) {
        int foundCarIndex = indexOf(car);

        return (foundCarIndex == -1) ? null : carRepository.getCars()[foundCarIndex];
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
