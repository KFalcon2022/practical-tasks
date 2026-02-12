package com.walking.lesson38_comparing.task1.comparators;

import com.walking.lesson38_comparing.task1.model.Car;

import java.util.Comparator;

public class CarYearComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getIdentifier().getYear() - o2.getIdentifier().getYear();
    }
}
