package com.walking.lesson49_optional.task2.service;


import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CarService {
    private final Map<CarIdentifier, Car> cars = new HashMap<>();

    public CarService(Car[] cars) {
        for (Car car : cars) {
            this.cars.put(car.getIdentifier(), car);
        }
    }

    public Optional<Car> findCar(CarIdentifier identifier) {
        return Optional.ofNullable(cars.get(identifier));
    }
}
