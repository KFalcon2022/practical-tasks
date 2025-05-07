package com.walking.lesson47_method_reference.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarService {
    private final HashMap<Integer, Car> carsCollection = new HashMap<>();

    public CarService(Car... cars) {
        List.of(cars).forEach(this::addCar);
    }

    public void addCar(Car car) {
        // hashcode as unique car id number
        carsCollection.put(car.getHashCode(), car);
    }

    public List<Car> findCars(Filter filter, String target) {
        List<Car> foundCarsList = new ArrayList<>();

        carsCollection.values().forEach(car -> {
            if (filter.matcher().test(car, target)) {
                foundCarsList.add(car);
            }
        });

        return foundCarsList;
    }
}
