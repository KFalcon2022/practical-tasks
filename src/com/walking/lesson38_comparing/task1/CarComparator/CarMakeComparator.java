package com.walking.lesson38_comparing.task1.CarComparator;

import com.walking.lesson38_comparing.task1.Car;

import java.util.Comparator;

public class CarMakeComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getCarMake() == null || car2.getCarMake() == null ) {
            System.out.println("Null object!");
        }

        return car1.getCarMake().compareTo(car2.getCarMake());
    }
}
