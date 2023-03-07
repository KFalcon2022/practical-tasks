package com.walking.lesson38_comparing.task1.comparator;

import com.walking.lesson38_comparing.task1.model.Car;

import java.util.Comparator;

public class NumberComparator implements Comparator<Car> {
    @Override
    public int compare(Car firstCar, Car secondCar) {
        return firstCar.getIdentifier().getNumber().compareTo(secondCar.getIdentifier().getNumber());
    }
}
