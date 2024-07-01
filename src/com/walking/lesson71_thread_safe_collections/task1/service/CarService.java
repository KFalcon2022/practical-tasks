package com.walking.lesson71_thread_safe_collections.task1.service;

import com.walking.lesson71_thread_safe_collections.task1.model.Car;
import com.walking.lesson71_thread_safe_collections.task1.model.CarIdentifier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarService {
    Map<CarIdentifier, Car> cars = new ConcurrentHashMap<>();

    public synchronized Car findCar(CarIdentifier identifier) {
        return cars.get(identifier);
    }

    public Car add(Car car) {
        cars.compute(car.getIdentifier(), (k, v) -> {
            if (v != null) {
                throw new RuntimeException("Car exist");
            }

            return car;
        });

        return car;
    }

    public synchronized Car update(Car updated) {
        return cars.compute(updated.getIdentifier(), (k, v) -> {
            if (v == null) {
                throw new RuntimeException("Car not exist");
            }

            v.setColor(updated.getColor());
            v.setActualTechnicalInspection(updated.isActualTechnicalInspection());

            return v;
        });
    }

    public void delete(Car car) {
        cars.remove(car.getIdentifier());
    }
}
