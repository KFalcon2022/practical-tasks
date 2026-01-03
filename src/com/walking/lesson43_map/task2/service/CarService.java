package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.model.CarIdentifier;

import java.util.HashMap;
import java.util.Map;

public class CarService {
    private final Map<CarIdentifier, Car> carMap;

    public CarService() {
        this.carMap = new HashMap<>();
    }

    public CarService(Map<CarIdentifier, Car> carMap) {
        this.carMap = Map.copyOf(carMap);
    }

    public Car put(Car car) {
        return carMap.put(car.getIdentifier(), car);
    }

    public Car remove(Car car) {
        return carMap.remove(car.getIdentifier());
    }

    public Car get(CarIdentifier identifier) {
        return carMap.get(identifier);
    }

    public Map<CarIdentifier, Car> getCarMap() {
        return Map.copyOf(carMap);
    }
}
