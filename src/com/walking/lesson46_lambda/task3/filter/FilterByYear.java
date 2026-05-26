package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class FilterByYear implements Filter {
    private final int start;
    private final int end;

    public FilterByYear(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean filter(Car car) {
        return car.getReleaseYear() >= start && car.getReleaseYear() <= end;
    }
}
