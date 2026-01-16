package com.walking.lesson46_lambda.task3.domain.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class NumberSubstringCarFilter implements CarFilter{
    private final String numberSubString;

    public NumberSubstringCarFilter(String numberSubString) {
        this.numberSubString = numberSubString;
    }

    @Override
    public boolean filter(Car car) {
        String carNumber = car.getIdentifier().getNumber();

        return carNumber.contains(numberSubString);
    }
}
