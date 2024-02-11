package com.walking.lesson38_comparing.task2.comparators;

import com.walking.lesson38_comparing.task2.models.*;

import java.util.Comparator;

public class CarUpSortComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.compareTo(o2);
    }
}
