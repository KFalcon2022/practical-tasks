package com.walking.lesson49_optional.task1.service;

import com.walking.lesson49_optional.task1.model.Car;

import java.util.Map;
import java.util.Optional;

public class CarService {
    private final Map<String, Car> cars;

    public CarService(Map<String, Car> cars) {
        this.cars = cars;
    }

    public Optional<Car> findCar(String number) {
        return Optional.ofNullable(number)
                .map(cars::get);
    }
}
