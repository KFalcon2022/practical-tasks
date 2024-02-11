package com.walking.lesson49_optional.task1.service;

import com.walking.lesson19_object_methods.model.Car;

import java.util.HashMap;
import java.util.Optional;

public class CarSearchService {
    private static HashMap<Integer, Car> cars =new HashMap<>();

    public static void findCar(HashMap<Integer, Car> inCars){
        cars=inCars;

        final String VIN = InputService.getVIN();
        final String plateNumber = InputService.getPlateNumber();
        InputService.close();

        Car checkCar = new Car ("Car for check","Car for check", VIN, plateNumber);
        findCar(checkCar.hashCode(),checkCar)
                .ifPresentOrElse(
                        System.out::println,
                        ()-> System.out.println("No match"));
    }
    private static Optional<Car> findCar (int hashcode, Car checkCar){
        return Optional.ofNullable(cars.get(hashcode))
                .filter(car->car.equals(checkCar));
    }
}
