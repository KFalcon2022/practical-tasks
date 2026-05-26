package com.walking.lesson47_method_reference.task3.service;

import com.walking.lesson47_method_reference.task3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService {

    public static List<Car> find(List<Car> cars, Predicate<Car> condition) {
        List<Car> matchingCars = new ArrayList<>();
        cars.forEach(car -> {
            if (condition.test(car)) {
                matchingCars.add(car);
            }
        });
        return matchingCars;
    }
}
