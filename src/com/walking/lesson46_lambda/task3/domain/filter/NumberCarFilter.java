package com.walking.lesson46_lambda.task3.domain.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class NumberCarFilter implements CarFilter {
    private final String number;

    public NumberCarFilter(String number) {
        this.number = number;
    }

    @Override
    public boolean filter(Car car) {
        return number.equals(car.getIdentityCar().getStateNumber());
    }
}
