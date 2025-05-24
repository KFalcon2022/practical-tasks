package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.CarNotFoundException;
import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.CarIdentifier;

public class CarService {
    private final Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car findCar(CarIdentifier identifier) throws CarNotFoundException {
        for (Car c : cars) {
            if (c.getIdentifier().equals(identifier)) {
                return c;
            }
        }
        throw new CarNotFoundException();
    }
}
