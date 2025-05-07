package com.walking.lesson46_lambda.task3.domain.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class ColorCarFilter implements CarFilter {
    private final String color;

    public ColorCarFilter(String color) {
        this.color = color;
    }

    @Override
    public boolean filter(Car car) {
        return color.equalsIgnoreCase(car.getColor().toString());
    }
}
