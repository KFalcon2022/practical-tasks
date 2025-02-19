package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

import java.util.function.Predicate;

public class NumberFilter implements Predicate<Car> {
    private final String number;

    public NumberFilter(String number) {
        this.number = number;
    }

    @Override
    public boolean test(Car car) {
        return number.equalsIgnoreCase(car.getVariables().getCarNumber());
    }
}
