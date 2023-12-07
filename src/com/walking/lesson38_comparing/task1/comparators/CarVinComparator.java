package com.walking.lesson38_comparing.task1.comparators;

import com.walking.lesson38_comparing.task1.models.Car;

import java.util.Comparator;

public class CarVinComparator implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getVIN().compareTo(o2.getVIN());
    }
}
