package com.walking.lesson49_optional.task2.filter;

import com.walking.lesson49_optional.task2.model.Car;

import java.util.function.Predicate;

public class OwnerAdressFilter implements Predicate<Car> {
    private final String FORBIDDEN_ADDRESS="Рублевское шоссе";
    @Override
    public boolean test(Car car) {
        return car.getOwner()
                .getHouse()
                .getAddress()
                .contains(FORBIDDEN_ADDRESS);
    }
}
