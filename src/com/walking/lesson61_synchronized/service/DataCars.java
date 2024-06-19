package com.walking.lesson61_synchronized.service;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentifier;

import java.util.HashMap;
import java.util.Map;

public class DataCars {
    private Map<CarIdentifier, Car> cars = initCars();

    public Map<CarIdentifier, Car> getCars() {
        return cars;
    }

    private Map<CarIdentifier, Car> initCars() {
        Map<CarIdentifier, Car> cars = new HashMap<>();

        Car car1 = new Car("RRR-111-XX", 2022, "red", true);
        Car car2 = new Car("RRR-222-XX", 2021, "blue", true);
        Car car3 = new Car("RRR-333-XX", 2022, "green", true);
        Car car4 = new Car("RRR-444-XX", 2023, "red", true);
        Car car5 = new Car("RRR-555-XX", 2024, "white", true);
        Car car6 = new Car("RRR-666-XX", 2020, "black", true);
        Car car7 = new Car("RRR-777-XX", 2022, "gold", true);
        Car car8 = new Car("RRR-888-XX", 2024, "gold", true);
        Car car9 = new Car("RRR-999-XX", 2022, "silver", true);
        Car car10 = new Car("RRR-000-XX", 2021, "red", true);

        cars.put(car1.getCarIdentifier(), car1);
        cars.put(car2.getCarIdentifier(), car2);
        cars.put(car3.getCarIdentifier(), car3);
        cars.put(car4.getCarIdentifier(), car4);
        cars.put(car5.getCarIdentifier(), car5);
        cars.put(car6.getCarIdentifier(), car6);
        cars.put(car7.getCarIdentifier(), car7);
        cars.put(car8.getCarIdentifier(), car8);
        cars.put(car9.getCarIdentifier(), car9);
        cars.put(car10.getCarIdentifier(), car10);

        return cars;
    }
}
