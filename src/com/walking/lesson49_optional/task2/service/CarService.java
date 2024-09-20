package com.walking.lesson49_optional.task2.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import com.walking.lesson49_optional.task2.model.Car;

public class CarService {
    private HashMap<Integer,Car> cars;

    public CarService(Collection<Car> cars){
        this.cars=new HashMap<>();
        for (Car car : cars) {
            this.cars.put(Optional.ofNullable(car).map(Car::hashCode).orElseThrow(), car);
        }
    }

    public Optional<Car> findCar(Car car){
        return Optional.ofNullable(cars.get(car.hashCode()));
    }
}
