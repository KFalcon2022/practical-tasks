package com.walking.lesson61_synchronized.service;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentifier;

import java.util.HashMap;
import java.util.Map;

public class CarService {
    private final Map<CarIdentifier, Car> cars = new HashMap<>();

    public synchronized Car findCar(CarIdentifier identifier) {
        return cars.get(identifier);
    }

    public synchronized Car add(Car car) {
        if (cars.containsKey(car.getIdentifier())) {
            throw new RuntimeException("Car exists");
        }

        cars.put(car.getIdentifier(), car);

        return car;
    }

    public synchronized Car update(Car updated) {
        var old = cars.get(updated.getIdentifier());

        if (old == null) {
            throw new RuntimeException("Car not exists");
        }

        old.setColor(updated.getColor());
        old.setActualTechnicalInspection(updated.isActualTechnicalInspection());

        return old;
    }

    public synchronized void delete(Car car) {
        cars.remove(car.getIdentifier());
    }
}
