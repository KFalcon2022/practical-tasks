package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.model.Car;

public class CarService {
    private Car car;
    private Car[] cars;

    public boolean findCar(Car foundCar, Car[] cars) {
        for (Car car : cars) {
            if (car.equals(foundCar)) {
                return true;
            }
        }
        return false;
    }
}
