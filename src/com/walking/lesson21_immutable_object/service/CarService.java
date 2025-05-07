package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.IdentityCar;

public class CarService {
    Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car searchCar(IdentityCar searchingCar) {

        for (Car car : cars) {
            if (car.getIdentityCar().equals(searchingCar)) {
                return car;
            }
        }
        return null;
    }
}
