package com.walking.lesson46_lambda.task3.domain.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class DateBetweenCarFilter implements CarFilter {
    private final int yearFrom;
    private final int yearTo;

    public DateBetweenCarFilter(int yearFrom, int yearTo) {
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    @Override
    public boolean filter(Car car) {
        int carYear = car.getIdentifier().getYear();

        return yearFrom <= carYear && carYear <= yearTo;
    }
}
