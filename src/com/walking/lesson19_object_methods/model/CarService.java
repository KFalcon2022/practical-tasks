package com.walking.lesson19_object_methods.model;

public class CarService {
    private final Car[] cars;

    public CarService(Car[] allcars) {
        this.cars = allcars;
    }

    public Car searchCar(Car userCar) {
        for (Car car : cars) {
            if (car.equals(userCar)) {
                return car;
            }
        }
        return null;
    }
}
