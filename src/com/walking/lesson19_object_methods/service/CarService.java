package com.walking.lesson19_object_methods.service;

import com.walking.lesson19_object_methods.model.Car;

public class CarService {
    private final Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car findCar(Car car) {
        for (Car current : cars) {
            if (current.hashCode() == car.hashCode() && current.equals(car)) {
                return current;
            }
        }

        return null;
    }
}
