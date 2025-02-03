package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

import java.util.function.Predicate;

public class YearFilter implements Predicate<Car> {
    private final int minYear;
    private final int maxYear;

    public YearFilter(int minYear, int maxYear) {
        this.minYear = minYear;
        this.maxYear = maxYear;
    }

    @Override
    public boolean test(Car car) {
        return car.getVariables().getYear() >= minYear && car.getVariables().getYear() <= maxYear;
    }
}
