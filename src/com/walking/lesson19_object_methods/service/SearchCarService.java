package com.walking.lesson19_object_methods.service;

import com.walking.lesson19_object_methods.model.Car;

public class SearchCarService {

    public Car searchCar(Car searchingCar, Car[] cars) {

        for (Car car : cars) {
            if (car.equals(searchingCar)) {
                return searchingCar;
            }
        }
        return null;
    }
}
