package com.walking.lesson47_method_reference.task3.filter;

import com.walking.lesson47_method_reference.task3.model.Car;

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
