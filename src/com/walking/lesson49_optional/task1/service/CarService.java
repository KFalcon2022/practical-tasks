package com.walking.lesson49_optional.task1.service;

import com.walking.lesson49_optional.task1.model.Car;
import com.walking.lesson49_optional.task1.model.CarIdentifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CarService {
    private final Map<CarIdentifier, Car> cars = new HashMap<>();

    public CarService(Car[] cars) {
        for (Car car : cars) {
            this.cars.put(car.getCarIdentifier(), car);
        }
    }

    public Optional<Car> findCar(CarIdentifier carIdentifier) {
        return Optional.ofNullable(cars.get(carIdentifier));
    }
}
