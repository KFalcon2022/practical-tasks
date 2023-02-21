package com.walking.lesson49_optional.Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CarService {
    private final Map<String, Car> cars = new HashMap<>();

    public CarService(Car[] cars) {
        for (Car car : cars) {
            this.cars.put(car.getNumber(), car);
        }
    }

    public Set<String> getRegisteredNumbers() {
        return cars.keySet();
    }

    public Car findCar(String number) {
        return cars.get(number);
    }
    // Прошу заметить, что метод тот же что и в первой задаче. Один в один
    // Просто чтоб первую не переписывать
}