package com.walking.lesson71_thread_safe_collections.task1.service;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentificator;
import com.walking.lesson61_synchronized.service.CarServicePrintMessages;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class CarService {
    private final ConcurrentHashMap<CarIdentificator, Car> cars = new ConcurrentHashMap<>();

    private Car searchResult;

    public void add(Car... carsToAdd) {
        Arrays.stream(carsToAdd)
                .forEach(c -> cars.put(c.getCarIdentificator(), c));
    }

    public void delete(Car... carsToDelete) {
        Arrays.stream(carsToDelete)
                .forEach(c -> {
                    if (!cars.remove(c.getCarIdentificator(), c)) {
                        System.out.println("\n" + CarServicePrintMessages.CAR_NOT_FOUND + c + "\n");
                    }});
    }

    public void change(Car carToChange) {
        Car oldCar = search(carToChange);

        if (!cars.containsKey(carToChange.getCarIdentificator())) {
            throw new RuntimeException("Car to change doesn't exist!");
        }

        oldCar.setColor(carToChange.getColor());
    }

    public Car search(Car desiredCar) {
        return cars.get(desiredCar.getCarIdentificator());
    }

    public ConcurrentHashMap<CarIdentificator, Car> getCars() {
        return cars;
    }
}
