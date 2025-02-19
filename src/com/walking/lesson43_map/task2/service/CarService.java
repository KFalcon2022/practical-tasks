package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.model.Car;

import java.util.Map;

public class CarService {
    private final Map<String, Car> cars;

    public CarService(Map<String, Car> cars) {
        this.cars = cars;
    }

    public Car findCar(String number) {
        return cars.getOrDefault(number, null);
    }
}
