package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.CarId;

public class CarService {
    private final Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car findCar(CarId carId) {
        for (Car current : cars) {
            if(current.hashCode() == carId.hashCode() && current.getCarId().equals(carId) ) {
                return current;
            }
        }

        return null;
    }
}
