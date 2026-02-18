package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class FilterByColor implements Filter {
    private final String color;

    public FilterByColor(String color) {
        this.color = color;
    }

    @Override
    public boolean filter(Car car) {
        return car.getColor().equals(color);
    }
}
