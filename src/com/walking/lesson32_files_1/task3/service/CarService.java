package com.walking.lesson32_files_1.task3.service;
import com.walking.lesson21_immutable_object.car.Car;

import java.util.Arrays;

public class CarService {
    private Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (find(car) != null) {
            System.out.println("Такая машина уже существует.");
            return;
        }
        cars = Arrays.copyOf(cars, cars.length + 1);
        cars[cars.length - 1] = car;
    }

    public Car update(Car car) {
        Car existedCar = find(car);

        if (existedCar == null) {
            System.out.println("Машина не найдена.");
            return null;
        }

        existedCar.setOwner(car.getOwner());
        return existedCar;
    }

    public void delete(Car car) {
        int index = getIndex(car);
        if (index == -1) {
            System.out.println("Машина не найдена.");
            return;
        }

        Car[] updatedCars = new Car[cars.length - 1];
        for (int i = 0; i < cars.length; i++) {
            if (i < index) {
                updatedCars[i] = cars[i];
            }

            if (i > index) {
                updatedCars[i - 1] = cars[i];
            }
        }

        cars = updatedCars;
    }

    private Car find(Car car) {
        for (Car c : cars) {
            if (c.hashCode() == car.hashCode() && c.equals(car)) {
                return c;
            }
        }
        return null;
    }

    private int getIndex(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].equals(car) && cars[i].hashCode() == car.hashCode()) {
                return i;
            }
        }
        return -1;
    }

    public Car[] getCars() {
        return cars;
    }
}
