package com.walking.lesson46_lambda.task3.domain.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class NumberSubstringCarFilter implements CarFilter {
    private final String substringNumber;

    public NumberSubstringCarFilter(String substringNumber) {
        this.substringNumber = substringNumber;
    }

    @Override
    public boolean filter(Car car) {
        String carNumber = String.valueOf(car.getIdentityCar().getStateNumber());

        return carNumber.contains(substringNumber);
    }
}
