package com.walking.lesson61_synchronized.service;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentifier;

import java.util.ArrayList;
import java.util.Map;

public final class CarService {
    private final Map<CarIdentifier, Car> cars = new DataCars().getCars();

    public CarService() {

    }

    public void printCars() {
        System.out.println(cars.values());
    }

    public Map<CarIdentifier, Car> getCarsDate() {
        return cars;
    }

    public synchronized Car addCar(Car car) {
        cars.put(car.getCarIdentifier(), car);

        return car;
    }

    public synchronized Car deleteCar(Car car) {
        return cars.remove(car.getCarIdentifier());
    }

    public synchronized boolean replaceInfo(Car car) {
        if (cars.containsKey(car.getCarIdentifier())) {
            cars.replace(car.getCarIdentifier(), car);
        }

        throw new RuntimeException("Машины не существует!");
    }

    public Car findCar(Car car) {
        if (cars.containsKey(car.getCarIdentifier())) {
            return cars.get(car.getCarIdentifier());
        }

        throw new RuntimeException("Машина не найдена!");
    }
}
