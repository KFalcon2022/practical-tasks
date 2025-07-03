package com.walking.lesson21_immutable_object.car;

public class CarService {

    public static Car find(Car[] cars, Car car) {
        for (Car c : cars) {
            if (c.equals(car)) {
                return c;
            }
        }
        return null;
    }
}
