package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.exception.CarNotFound;
import com.walking.lesson43_map.task2.model.Car;

import java.util.Map;

public class CarService {
    private final Map<Integer, Car> carService;

    public CarService(Map<Integer, Car> cars) {
        this.carService = cars;
    }

    public Car findCar(Car car) {
        if (carService.containsKey(car.getHashcode())) {
            return carService.get(car.getHashcode());
        }

        throw new CarNotFound("Машина не найдена!");
    }
}
