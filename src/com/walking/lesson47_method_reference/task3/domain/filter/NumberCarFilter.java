package com.walking.lesson47_method_reference.task3.domain.filter;

import com.walking.lesson47_method_reference.task3.model.Car;

public class NumberCarFilter implements CarFilter {
    private final String number;

    public NumberCarFilter(String number) {
        this.number = number;
    }

    @Override
    public boolean filter(Car car) {
        String carNumber = car.getIdentifier().getNumber();

        return number.equals(carNumber);
    }
}
