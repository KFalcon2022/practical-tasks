package com.walking.lesson38_comparing.task1.CarComparator;

import com.walking.lesson38_comparing.task1.Car;

import java.util.Comparator;

public class CarColorComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getColor().compareTo(car2.getColor());
    }
}
