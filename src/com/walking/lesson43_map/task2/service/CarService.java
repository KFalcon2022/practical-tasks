package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.exception.CarNotFound;
import com.walking.lesson43_map.task2.model.Car;

import java.util.TreeMap;

public class CarService {
    private final TreeMap<Integer, Car> carService;

    public CarService(TreeMap<Integer, Car> carService) {
        this.carService = carService;
    }

    public String findCar(Car car) {
        for (Car c : carService.values()) {
            if (c.equals(car)) {
                return c.toString();
            }
        }

        throw new CarNotFound("Машина не найдена!");
    }
}
