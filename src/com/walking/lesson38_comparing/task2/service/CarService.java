package com.walking.lesson38_comparing.task2.service;

import com.walking.lesson38_comparing.task2.model.Car;
import com.walking.lesson38_comparing.task2.model.CarIdentifier;

public class CarService {
    private final Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car findCar(CarIdentifier identifier) {
        for (Car c : cars) {
            if (c.getIdentifier().equals(identifier)) {
                return c;
            }
        }
        return null;
    }
}
