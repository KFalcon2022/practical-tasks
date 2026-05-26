package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class FilterByOwner implements Filter {
    private final String owner;

    public FilterByOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean filter(Car car) {
        return car.getOwner().equals(owner);
    }
}
