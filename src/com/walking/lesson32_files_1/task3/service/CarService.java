package com.walking.lesson32_files_1.task3.service;

import com.walking.lesson32_files_1.task3.model.Car;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CarService {
    Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getCars() {
        return cars;
    }

    public Car addCar(Car newCar) {
        Car existsCar = findCar(newCar);

        if (existsCar != null) {
            return existsCar;
        }

        Car[] newCars = new Car[cars.length + 1];
        for(int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i];
        }
        newCars[newCars.length - 1] = newCar;
        cars = newCars;

        return newCar;
    }

    public Car updateCar(Car car) {

        Car exsistsCar = findCar(car);

        if (findCar(car) ==  null) {
            throw new RuntimeException("Машина не существует.");
        }

        exsistsCar.setColor(car.getColor());

        return exsistsCar;
    }

    public void deleteCar(Car deleteCar) {
        Car existsCar = findCar(deleteCar);

        if (existsCar == null) {
            throw new RuntimeException("Машина не существует.");
        }

        Car[] newCars = new Car[cars.length - 1];
        int indexCar = findIndexCar(deleteCar);
        int j = 0;

        for(int i = 0; i < cars.length; i++) {
            if (i != indexCar) {
                newCars[j] = cars[i];
                j++;
            }

        }

        cars = newCars;
    }

    private Car findCar(Car newCar) {

        for (Car car : cars) {
            if (car.equals(newCar)) {
                return car;
            }
        }

        return null;
    }

    private int findIndexCar(Car searchCar) {

        for (int i = 0; i < cars.length; i++) {
            if (searchCar.equals(cars[i])) {
                return i;
            }
        }

        return 0;
    }
}
