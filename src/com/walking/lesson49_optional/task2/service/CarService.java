package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentifier;
import com.walking.lesson49_optional.task2.model.Human;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CarService {
    private final Map<CarIdentifier, Car> carMap;

    public CarService() {
        this.carMap = new HashMap<>();
    }

    public CarService(Map<CarIdentifier, Car> carMap) {
        this.carMap = new HashMap<>(carMap);
    }

    public Car put(Car car) {
        return carMap.put(car.getIdentifier(), car);
    }

    public Car put(CarIdentifier id, Human human) {
        Car car = new Car(id, human);
        human.setCar(car);
        return put(car);
    }

    public Car remove(Car car) {
        return carMap.remove(car.getIdentifier());
    }

    public Optional<Car> get(CarIdentifier identifier) {
        return Optional.ofNullable(identifier)
                .map(carMap::get);
    }

    public Map<CarIdentifier, Car> getCarMap() {
        return Map.copyOf(carMap);
    }
}
