package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.Car.Car;
import com.walking.lesson49_optional.task2.model.Car.CarIdenty;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CarService {
    private final Map<CarIdenty, Car> cars = new HashMap<>();

    public CarService(Car[] cars) {
        for (Car car : cars) {
            this.cars.put(car.getIdenty(), car);
        }
    }

    public Optional<Car> getCar(CarIdenty identy) {
        Optional<Car> findedCar = Optional.ofNullable(cars.get(identy));
        return findedCar;
    }
}
