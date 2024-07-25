package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.model.Car;

public class CarService {
    private final Car [] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car foundCar(Car car) {
            for (Car c : cars) {
                if(c.equals(car)) {
                    return c;
                }
            }

        throw new RuntimeException("Машина не обнаружена");
    }
}
