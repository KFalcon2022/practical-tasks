package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.model.CarIdentifier;

import java.util.HashMap;

public class CarService {
    private final HashMap<CarIdentifier, Car> carMap;

    public CarService() {
        this.carMap = new HashMap<>();
    }

    public CarService(HashMap<CarIdentifier, Car> carMap) {
        this.carMap = carMap;
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

    public HashMap<CarIdentifier, Car> getCarMap() {
        return carMap;
    }
}
