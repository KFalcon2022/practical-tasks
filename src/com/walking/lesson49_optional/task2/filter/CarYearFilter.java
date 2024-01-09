package com.walking.lesson49_optional.task2.filter;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentificator;

import java.util.function.Predicate;

public class CarYearFilter implements Predicate<Car> {
    private final int YEAR_TO_COMPARE=2021;
    @Override
    public boolean test(Car car) {
        return car.getCarIdentificator().getReleaseYear()>YEAR_TO_COMPARE;
    }
}
