package com.walking.lesson61_synchronized.service;

import com.walking.lesson61_synchronized.model.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;;

public class CarService {
    private final List<Car> cars;

    public CarService(Collection<? extends Car> collection) {
        cars = new ArrayList<>(collection.size());

        cars.addAll(collection);
    }

    public List<Car> getAll() {
        return cars;
    }

    public synchronized Car add(Car car) {
        Car existedCar = find(car);

        if (existedCar != null) {
            System.out.println("Car already existed");

            return existedCar;
        }

        cars.add(car);

        return car;
    }

    public synchronized Car update(Car car) {
        Car existedCar = find(car);

        if (existedCar == null) {
            throw new RuntimeException(
                    "Non-existent car cannot be updated. Number: %s, year: %d".formatted(car.getNumber(),
                            car.getYear()));
        }

        existedCar.setColor(car.getColor());
        existedCar.setFine(car.hasFine());

        return existedCar;
    }

    public synchronized void delete(Car car) {
        if (!cars.remove(car)) {
            System.out.println("Car is not exist");
        }
    }

    public Car find(Car car) {
        return cars.stream()
                   .filter(c -> c.hashCode() == car.hashCode() && c.equals(car))
                   .findAny()
                   .orElse(null);
    }
}
