package com.walking.lesson47_method_reference.task3.service;

import com.walking.lesson47_method_reference.task3.model.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public CarService(Collection<? extends Car> cars) {
        this.cars.addAll(cars);
    }

    public List<Car> findBy(Predicate<Car> predicate) {
        List<Car> found = new ArrayList<>();

        cars.forEach(car -> {
            if (predicate.test(car)) {
                found.add(car);
            }
        });

        return found;
    }
}
