package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

import java.util.function.Predicate;

public class NumberSubstringFilter implements Predicate<Car> {
    private final String numberSubstring;

    public NumberSubstringFilter(String numberSubstring) {
        this.numberSubstring = numberSubstring;
    }

    @Override
    public boolean test(Car car) {
        return car.getVariables().getCarNumber().contains(numberSubstring);
    }
}
