package com.walking.lesson33_files_2.task1;

public class CarService {
    private final Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car findCar(Car c) {
        for (Car car : cars) {
            if (c.hashCode() == car.hashCode() && c.equals(car)) {
                return car;
            }
        }
        return null;
    }
}
