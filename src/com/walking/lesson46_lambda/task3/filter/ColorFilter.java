package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

import java.util.function.Predicate;

public class ColorFilter implements Predicate<Car> {
   private final String color;

    public ColorFilter(String color) {
        this.color = color;
    }

    @Override
    public boolean test(Car car) {
        return color.equalsIgnoreCase(car.getColor());
    }
}
