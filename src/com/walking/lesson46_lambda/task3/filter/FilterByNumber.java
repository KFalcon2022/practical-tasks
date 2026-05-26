package com.walking.lesson46_lambda.task3.filter;

import com.walking.lesson46_lambda.task3.model.Car;

public class FilterByNumber implements Filter {
    private final String number;

    public FilterByNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean filter(Car car) {
        return car.getIdentifier().getNumber().equals(number);
    }
}
