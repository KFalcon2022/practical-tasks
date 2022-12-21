package com.walking.lesson32_files_1.task3.service;

import com.walking.lesson32_files_1.task3.model.Car;

import java.util.Arrays;

public class CarService {
    private Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getAll() {
        return cars;
    }

    public Car add(Car car) {
        Car existedCar = find(car);

//        Поскольку у машины есть уникальный набор полей, двух одинаковых машин быть не может
        if (existedCar != null) {
            System.out.println("Car already exists");

            return existedCar;
        }

        cars = Arrays.copyOf(cars, cars.length + 1);
        cars[cars.length - 1] = car;

        return car;
    }

    public Car update(Car car) {
        Car existedCar = find(car);

        if (existedCar == null) {
            throw new RuntimeException(
                    "Non-existent car cannot be updated. Number: %s, year: %d".formatted(car.getNumber(), car.getYear()));
        }

        existedCar.setColor(car.getColor());
        existedCar.setActualTechnicalInspection(car.isActualTechnicalInspection());

        return existedCar;
    }

    public void delete(Car car) {
        Integer index = findCarIndex(car);

        if (index == null) {
            System.out.println("Car is not exist");
            return;
        }

        if (index == cars.length - 1) {
            cars = Arrays.copyOf(cars, cars.length - 1);
            return;
        }

        Car[] newCars = new Car[cars.length - 1];

        int i = 0;
        int j = 0;
        while (j < newCars.length) {
            if (i != index) {
                newCars[j] = cars[i];
                j++;
            }

            i++;
        }

        cars = newCars;
    }

    public Car find(Car car) {
        for (Car c : cars) {
            if (c.hashCode() == car.hashCode() && c.equals(car)) {
                return c;
            }
        }

        return null;
    }

    private Integer findCarIndex(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].hashCode() == car.hashCode() && cars[i].equals(car)) {
                return i;
            }
        }

        return null;
    }
}
