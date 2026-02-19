package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.model.Car;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CarService {
    private final Set<Car> cars;

    public CarService(Collection<Car> cars) {
        this.cars = new HashSet<>(cars);
    }

    public Set<Car> findCars(Predicate<Car> predicate) {
        Set<Car> filteredCars = new HashSet<>();

        cars.forEach(car -> {
            if (predicate.test(car)) {
                filteredCars.add(car);
            }
        });

        return filteredCars;
    }
}
