package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.model.IdentityCar;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CarService {
    private final Set<Car> cars;

    public CarService(Set<Car> cars) {
        this.cars = new HashSet<>(cars);
    }

    public Set<Car> searchCars(Predicate<Car> predicate) {
        Set<Car> result = new HashSet<>();

        cars.forEach(car -> {
            if (predicate.test(car)) {
                result.add(car);
            }
        });

        return result;
    }
}
