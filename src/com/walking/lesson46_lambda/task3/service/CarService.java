package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService {

    public static List<Car> find(List<Car> cars, Predicate<Car> condition) {
        List<Car> matchingCars = new ArrayList<>();
        for (Car c : cars) {
            if (condition.test(c)) {
                matchingCars.add(c);
            }
        }
        return matchingCars;
    }
}
