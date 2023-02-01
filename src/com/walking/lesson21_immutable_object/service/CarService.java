package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.model.Car;

public class CarService {

    private Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car findCar(Car searchedCar) {
        for (Car car : cars) {
            if (car.equals(searchedCar)) {
                return car;
            }
        }
        return null;
    }

}
