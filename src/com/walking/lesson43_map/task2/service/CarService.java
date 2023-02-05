package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.model.CarIdentifier;

import java.util.HashMap;
import java.util.Map;

public class CarService {
    private final Map<CarIdentifier, Car> cars = new HashMap<>();

    public CarService(Car[] cars) {
        for (Car car : cars) {
            this.cars.put(car.getIdentifier(), car);
        }
    }

    public Car findCar(CarIdentifier identifier) {
        return cars.get(identifier);
    }
}
