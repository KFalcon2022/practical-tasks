package com.walking.lesson46_lambda.task3.domain.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class NumberSubstringCarFilter implements CarFilter {
    private final String numberSubstring;

    public NumberSubstringCarFilter(String numberSubstring) {
        this.numberSubstring = numberSubstring;
    }

    @Override
    public boolean filter(Car car) {
        String carNumber = car.getIdentifier().getNumber();

        return carNumber.contains(numberSubstring);
    }
}
